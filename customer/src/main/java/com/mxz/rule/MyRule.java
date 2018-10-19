package com.mxz.rule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
/**
 * 每个服务调用5次后再进行轮询
 * @author Administrator
 *
 */
public class MyRule extends AbstractLoadBalancerRule{

    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);
    
    private AtomicInteger nextServerCyclicCounter;
    private static final boolean AVAILABLE_ONLY_SERVERS = true;
    private static final boolean ALL_SERVERS = false;
    private int total = 0;
    private int currentIndex = 0;
    
    public MyRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }
    
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	private Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			log.warn("no load balancer");
            return null;
		}
		Server server = null;
	    int count = 0;
		 while (server == null && count++ < 10) {
	            List<Server> reachableServers = lb.getReachableServers();
	            List<Server> allServers = lb.getAllServers();
	            int upCount = reachableServers.size();
	            int serverCount = allServers.size();

	            if ((upCount == 0) || (serverCount == 0)) {
	                log.warn("No up servers available from load balancer: " + lb);
	                return null;
	            }
	            if (total > 5) {
	                total = 0;
	                int nextServerIndex = incrementAndGetModulo(serverCount);
	                currentIndex = nextServerIndex;
	                server = allServers.get(nextServerIndex);
	            }else {
	                if (currentIndex>=serverCount) {
	                    currentIndex = 0;
	                }
	                server = allServers.get(currentIndex);
	                total++;
	            }


	            if (server == null) {
	                /* Transient. */
	                Thread.yield();
	                continue;
	            }

	            if (server.isAlive() && (server.isReadyToServe())) {
	                return (server);
	            }

	            // Next.
	            server = null;
	        }

	        if (count >= 10) {
	            log.warn("No available alive servers after 10 tries from load balancer: "
	                    + lb);
	        }
	        return server;
	}
	
	private int incrementAndGetModulo(int modulo) {
	        for (;;) {
	            int current = nextServerCyclicCounter.get();
	            int next = (current + 1) % modulo;
	            if (nextServerCyclicCounter.compareAndSet(current, next))
	                return next;
	        }
	    }

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		
	}

}
