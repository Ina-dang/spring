package edu.biz.constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DevelopeApp {
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("const1.xml")
			.getBean("develope", Develope.class).coding();
	}
	
}
