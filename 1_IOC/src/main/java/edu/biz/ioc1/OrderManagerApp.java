package edu.biz.ioc1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc1.xml");
								//컨텍스트로 빈 가져옴
		OrderManager manager = ctx.getBean("orderManager", OrderManager.class);
		manager.order();
		ctx.close();
	}
}
