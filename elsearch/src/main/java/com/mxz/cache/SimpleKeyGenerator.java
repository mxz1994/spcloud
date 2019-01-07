package com.mxz.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

/**
* <p>Title: SimpleKeyGenerator.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月22日  
*/
public class SimpleKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return null;
	}
}
