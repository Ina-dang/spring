package edu.biz.ioc5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hm") //이제 이게 빈 이름이 됨
public class HyundaiMaker implements CarMaker {
//	public Car sell(Money money){
//		return new Car("sonata");
//	}
	@Autowired
	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}
	
	public Car sell(Money money){
		return car;
	}	
}
