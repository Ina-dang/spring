package edu.biz.smallMart2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmallMartApp3 {
	public static void main(String[] args) {
		//이 안에서 겟빈을 통해 가져올거임
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small2.xml");
		System.out.println("=========================");
		
		//겟빈으로 가ㅕ온 마트
		SmallMart mart2 = ctx.getBean("mart4", SmallMart.class);
		try {
			mart2.getProduct2("우유");
			mart2.getProduct2("까까");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
