package com.mxz.provider.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class HelloServiceHystrixFactory implements FallbackFactory<HelloService>{

	@Override
	public HelloService create(Throwable cause) {
		return new HelloService(){
			@Override
			public String hello(String name) {
				//根据异常返回不同值进行熔断
				String str = "";
				if (cause instanceof IllegalArgumentException) {
					str = "参数异常";
				} else {
					str = "谁知道什么异常";
				}
				return super.hello(name);
			}
		};
	}

}
