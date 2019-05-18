package com.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void springConfig(){
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@Test
	public void test(){
		System.out.println(ctx);
	}
}
