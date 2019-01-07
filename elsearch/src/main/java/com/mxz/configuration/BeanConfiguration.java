package com.mxz.configuration;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* <p>Title: BeanConfiguration.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月22日  
*/

@Configuration
public class BeanConfiguration {

//	@Bean
//	public BeanNameAutoProxyCreator datasourceBeforAutoProxy() {
//		BeanNameAutoProxyCreator dataSourceAutoProxy = new BeanNameAutoProxyCreator();
//		// 使用使用cglib代理
//		dataSourceAutoProxy.setProxyTargetClass(true);
//		dataSourceAutoProxy.setBeanNames(new String[] { "*Controller" });
//		dataSourceAutoProxy.setInterceptorNames(new String[] { "RunTimeInterceptor" });
//		dataSourceAutoProxy.setOrder(10);
//		return dataSourceAutoProxy;
//	}
}
