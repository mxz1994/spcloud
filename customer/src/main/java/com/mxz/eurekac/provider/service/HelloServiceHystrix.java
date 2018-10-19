package com.mxz.eurekac.provider.service;

public class HelloServiceHystrix implements HelloFeginService{

	@Override
	public String hello(String name) {
		return "出错熔断机制";
	}

}
