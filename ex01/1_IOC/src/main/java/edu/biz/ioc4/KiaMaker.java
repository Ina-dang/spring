package edu.biz.ioc4;

public class KiaMaker implements CarMaker {
	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}

	public Car sell(Money money){
		return car;
	}
}
