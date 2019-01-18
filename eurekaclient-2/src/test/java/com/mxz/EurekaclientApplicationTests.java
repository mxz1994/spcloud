package com.mxz;

import com.mxz.Config.AopConfig;
import com.mxz.service.MathCalactor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class EurekaclientApplicationTests {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);

	@Test
	public void contextLoads() {
		MathCalactor logAspect = ac.getBean(MathCalactor.class);
		System.out.println("logAspect.div(1,2) = " + logAspect.div(1, 2));
	}

}
