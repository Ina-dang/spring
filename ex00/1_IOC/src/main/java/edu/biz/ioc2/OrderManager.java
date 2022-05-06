package edu.biz.ioc2;

public class OrderManager {
	private CarMaker maker;
	
	public OrderManager(){
		maker = new HyundaiMaker();
	}
	
	public void order(){
		Money money = new Money(2000);
		Car car = maker.sell(new Money(2000));
		System.out.println("I sold a car :: " + car.getName() + ", " + money.getAmount());
	}
}
