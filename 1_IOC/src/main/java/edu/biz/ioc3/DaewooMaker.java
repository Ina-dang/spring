package edu.biz.ioc3;

public class DaewooMaker implements CarMaker {
	public Car sell(Money money){
		return new Car("tosca");
	}
}
