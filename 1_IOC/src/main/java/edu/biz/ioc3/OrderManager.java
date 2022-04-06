package edu.biz.ioc3;

public class OrderManager {
	private CarMaker maker;
	
	public OrderManager(){
		maker = new KiaMaker();
	}
	
	public void order(){
		Money money = new Money(2000);
		Car car = maker.sell(new Money(2000));
		System.out.println("I sold a car :: " + car.getName() + ", " + money.getAmount());
	}
}
