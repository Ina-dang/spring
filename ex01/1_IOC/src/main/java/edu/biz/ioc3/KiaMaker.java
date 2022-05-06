package edu.biz.ioc3;

public class KiaMaker implements CarMaker {
	public Car sell(Money money){
		return new Car("k5");
	}
}
