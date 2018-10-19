package com.mxz.eurekac.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE2", fallback = HelloServiceHystrix.class)
public interface HelloFeginService {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello(@RequestParam(value = "name") String name);
}
