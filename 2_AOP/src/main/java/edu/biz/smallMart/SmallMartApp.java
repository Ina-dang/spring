package edu.biz.smallMart;

import org.springframework.aop.framework.ProxyFactory;

import edu.biz.smallMart.advice.AfterRetLog;
import edu.biz.smallMart.advice.AroundLog;
import edu.biz.smallMart.advice.BeforeLog;
import edu.biz.smallMart.advice.ThrowsLog;

public class SmallMartApp {
	public static void main(String[] args) {
		SmallMart mart1 = new SmallMartImpl();
		try {
			mart1.getProduct("생필품"); //원본호출 예외만들어놔서 예외 무조건 발생
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.err.println("===============");
//		System.out.println("===============");
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BeforeLog()); //어드바이스의 인스턴스들
		pf.addAdvice(new AroundLog());
		pf.addAdvice(new AfterRetLog());
		pf.addAdvice(new ThrowsLog());
		pf.setTarget(mart1);
		
		SmallMart mart2 = (SmallMart)pf.getProxy();
		
		try {
			mart2.getProduct("전자제품");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
