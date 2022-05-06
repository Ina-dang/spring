package edu.biz.ioc5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//디펜던시 룩업 
// 인스턴스 직접생성
public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc5.xml");
										//컨텍스트로 빈 가져옴
		OrderManager manager = ctx.getBean("orderManager", OrderManager.class);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		manager.order();
		ctx.close();
	}
}
