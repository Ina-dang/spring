package edu.biz.app2;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import edu.biz.smallMart.advice.BeforeLog;

public class SimpleApp {
	public static void main(String[] args) {
		First first = new First();
		Second second = new Second();
		
		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new AroundLog()); // 이러면 다적용됨
		pf.addAdvisor(new DefaultPointcutAdvisor(new SimplePointcut(), new BeforeLog()));
		pf.setTarget(first);
		
		First first2 = (First) pf.getProxy();
		
		pf= new ProxyFactory();
//		pf.addAdvisor(new DefaultPointcutAdvisor(new SimplePointcut(), new AroundLog()));
		pf.addAdvice(new BeforeLog());
		pf.setTarget(second);
		
		Second second2 = (Second) pf.getProxy();
		
		first2.one();
		first2.two();
		second2.one();
		second2.two();
	}
}
