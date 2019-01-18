package com.mxz.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("execution(* com.mxz.service.*.*(..))")
    public void LogPoint(){}

    @Before("LogPoint()")
    public void before() {
        System.out.println("你好啊");
    }

}
