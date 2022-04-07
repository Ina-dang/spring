package edu.biz.jdkproxy;

import java.lang.reflect.Proxy;

public class HelloWorldApp {
	public static void main(String[] args) {
		HelloWorld world1 = new HelloWorldImpl();
		world1.sayHello("원본객체");
		
		System.out.println("===============");
		HelloWorld world2 = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(),
				new Class[] {HelloWorld.class}, new HelloWorldHandler(world1));
		
		world2.sayHello("대리객체");
		
		System.out.println("===============");
		System.out.println(world1);
		System.out.println(world2);
		
	}
}
