package edu.biz.ioc4;

public class HyundaiMaker implements CarMaker {
//	public Car sell(Money money){
//		return new Car("sonata");
//	}
	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}
	
	public Car sell(Money money){
		return car;
	}	
}
