package com.mxz.zuul.getway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
* <p>Title: AccessFilter.java</p>  
* <p>Description: 访问权限过滤器</p>  
* @author mxz
* @date 2018年11月26日  
*/
public class AccessFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return  "pre";
	}

	@Override
	public int filterOrder() {
		return 2;
	}
	
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		
		ctx.addZuulRequestHeader(name, value);
		boolean filterPass = false;
		try {
			filterPass = acc
		} catch (Exception e) {
			
		}
		return null;
	}
}
