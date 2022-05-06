package edu.biz.aop4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice{
	public void simpleBefore(JoinPoint joinPoint, int intValue){
		if (intValue > 5000) {
			System.out.println("advice 적용");
		}
	}
	
	//어라운드는 반드시 리턴필요
	public Object simpleAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("around");
		return pjp.proceed();
	}
	
	public void simpleAfter(JoinPoint joinPoint){
		System.out.println("after");
	}
}
