package edu.biz.smallMart5;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component @Aspect
public class SmallMartAdvise {
	@Before("execution(* *2(..))")
	public void smallBefore (JoinPoint joinPoint){
		System.out.println("사전적용");
	}
	
	public void smallAround (ProceedingJoinPoint joinPoint){
		System.out.println("어라운드");
	}
	
	public void smallNone(){
		System.out.println("되나");
	}
	
//	컨트롤러 파라미터처리에 편하다하심
	public void logging(JoinPoint jp){
		System.out.printf("[%s.%s(%s) :: %s] - ", 
		jp.getTarget().getClass().getName(), 
		jp.getSignature().getName(),
		Arrays.toString(jp.getArgs()),
		new SimpleDateFormat("yyyy-MM-dd hh:mma").format(System.currentTimeMillis()));
	}
}
