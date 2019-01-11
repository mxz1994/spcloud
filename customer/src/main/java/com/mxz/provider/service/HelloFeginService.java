package com.mxz.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "s1", fallback = HelloServiceHystrix.class, configuration = FeignConfig.class)
//fallbackFactory
public interface HelloFeginService {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello(@RequestParam(value = "name") String name);
}
