package edu.biz.ioc4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//디펜던시 룩업 
// 인스턴스 직접생성
public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc4.xml");
								//컨텍스트로 빈 가져옴
		OrderManager manager = ctx.getBean("orderManager", OrderManager.class);
		OrderManager manager2 = ctx.getBean("orderManager", OrderManager.class);
		OrderManager manager3 = ctx.getBean("orderManager", OrderManager.class);
		OrderManager manager4 = ctx.getBean("orderManager", OrderManager.class);
		OrderManager manager5 = ctx.getBean("orderManager", OrderManager.class);
		OrderManager manager6 = ctx.getBean("orderManager", OrderManager.class);
		manager.order();
		
		System.out.println(manager);
		System.out.println(manager2);
		System.out.println(manager3);
		System.out.println(manager4);
		System.out.println(manager5);
		System.out.println(manager6);
		
		
		Money money = ctx.getBean("money", Money.class);
		System.out.println(money.getAmount());
		System.out.println(ctx.getBean("money", Money.class));
		System.out.println(ctx.getBean("money", Money.class));
		System.out.println(ctx.getBean("money", Money.class));
		System.out.println(ctx.getBean("money", Money.class));
		System.out.println(ctx.getBean("money", Money.class));
		System.out.println(ctx.getBean("money", Money.class));
		ctx.close();
	}
}
