package com.mxz.eurekac.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mxz.eurekac.provider.service.HelloFeginService;
import com.mxz.eurekac.provider.service.HelloService;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    
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

