package edu.biz.smallMart3;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SmallMartApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small3.xml");
		System.out.println("=========================");
		
		SmallMart mart = ctx.getBean("mart", SmallMart.class);
			mart.getProduct("우유");
			mart.getProduct2("까까");
	}
}
