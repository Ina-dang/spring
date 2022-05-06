package edu.biz.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HelloWorldHandler implements InvocationHandler{
	//특정 이벤트가 발생했을 때 해야할 일들을 처리
	//ex >> event 해야할거 eventHandler
	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("전처리");
		Object obj = method.invoke(target, args);
		System.out.println("후처리");
		return obj;
	}
}
