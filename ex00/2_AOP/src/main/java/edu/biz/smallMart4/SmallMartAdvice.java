package edu.biz.smallMart4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component @Aspect
public class SmallMartAdvice {
	public void simpleBefore(JoinPoint joinPoint){
		System.out.println("비포");
	}
}
