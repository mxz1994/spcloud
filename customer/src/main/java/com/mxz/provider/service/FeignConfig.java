package com.mxz.provider.service;

import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

//配置自定义
@Configuration
public class FeignConfig extends FeignClientsConfiguration {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 1000, 5); //重试间隔为100ms，最大重试时间为1s,重试次数为5
    }
    
}