package com.mxz.interceptor;

import org.springframework.stereotype.Component;

/**
* <p>Title: RunTimeAspect.aj</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月23日  
*/

@Component
public aspect RunTimeAspect {
	private long d;
	
	pointcut request() : execution(* com.mxz.elsearch.controller.*.*(..));
	
	before() : request() {
		System.out.println(thisEnclosingJoinPointStaticPart); 
		System.out.println( thisJoinPoint);
		d = System.currentTimeMillis();
	}
	
	after() : request() {
		System.out.println(System.currentTimeMillis() - d);
	}
	
}
