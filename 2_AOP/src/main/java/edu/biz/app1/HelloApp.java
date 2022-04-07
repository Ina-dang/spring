package edu.biz.app1;

import org.springframework.aop.framework.ProxyFactory;

public class HelloApp {
	public static void main(String[] args) {
		HelloInter hello = new Hello();
		hello.sayHello();
		
		System.out.println("======================");
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MsgDecorator());
		pf.addAdvice(new MsgDecorator());
		pf.setTarget(hello);
		HelloInter hello2 = (HelloInter) pf.getProxy();
		
		hello2.sayHello();
		
		System.out.println("======================");
		System.out.println(hello);
		System.out.println(hello2);
		
		System.out.println("======================");
		System.out.println(hello.toString());
		System.out.println(hello2.toString());
		System.out.println(hello.hashCode());
		System.out.println(hello2.hashCode());
		System.out.println(String.format("%x", hello.hashCode()));
		System.out.println(String.format("%x", hello2.hashCode()));
		System.out.println(hello == hello2);
		
	}
}
