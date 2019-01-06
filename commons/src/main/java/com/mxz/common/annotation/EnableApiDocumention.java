package com.mxz.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.mxz.common.web.doc.SwaggerConfiguration;


/**
* <p>Title: EnableApiDocumention.java</p>  
* <p>Description: 配置swagger 文档</p>  
* @author mxz
* @date 2018年11月26日  
*/
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {SwaggerConfiguration.class})
public @interface EnableApiDocumention {

}
