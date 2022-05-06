package edu.biz.aop5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAdvice{
	@Pointcut("execution(* *(..)) ")
	public void pc(){}
	
	@Before("pc() && args(intValue)")	
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
