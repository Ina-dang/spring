package edu.biz.smallMart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLog implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around 사전");
		Object obj = invocation.proceed();
		System.out.println("Around 사후");
		return null;
	}
}
