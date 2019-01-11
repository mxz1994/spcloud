package com.mxz.provider.web;

import com.mxz.provider.service.HelloFeginService;
import com.mxz.provider.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @Qualifier("helloServiceHystrix")
    @Autowired
    HelloFeginService helloFeginService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hello( name );
    }
    
    @GetMapping(value = "/hifegin")
    public String hifegin(@RequestParam String name) {
        return helloFeginService.hello( name );
    }
}

