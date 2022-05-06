package edu.biz.ioc5;

public class DaewooMaker implements CarMaker {
//	public Car sell(Money money){
//		return new Car("tosca");
//	}
	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}

	public Car sell(Money money){
		return car;
	}
}
