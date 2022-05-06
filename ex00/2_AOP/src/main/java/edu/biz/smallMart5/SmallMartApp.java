package edu.biz.smallMart5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmallMartApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small5.xml");
		System.out.println("=========================");
		
		SmallMart mart = ctx.getBean("mart", SmallMart.class);
			mart.getProduct("우유");
			mart.getProduct2("까까");
	}
}
