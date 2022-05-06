package edu.biz.aop4;

import edu.biz.aop4.MyDependency;
import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public void run(){
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodbye();
	}
}
