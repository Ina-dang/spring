package edu.biz.smallMart.advice;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLog implements ThrowsAdvice{
	//구현하려는 대상 어드바이스 없음
	//근데 반드시 구현해야할 메서드 있어야함

							//예외최고조상클래스
	public void afterThrowing(Throwable throwable){
		System.out.println("ThrowsLog 에러발생");
	}
}
