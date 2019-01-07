package com.mxz.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
* <p>Title: RedisConfiguration.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月23日  
*/

@Configuration
public class RedisCacheManagerCustomizer {
	
	@Bean
	public CacheManagerCustomizer<RedisCacheManager> cacheManagerCustomizer() {
		return new CacheManagerCustomizer<RedisCacheManager>() {
			@Override
			public void customize(RedisCacheManager cacheManager) {
				Map<String, Long> expires = new HashMap<String, Long>();
				expires.put("menu", (long) 601);
			}
		};
	}
}
