package edu.biz.smallMart3;

import org.springframework.stereotype.Service;

@Service
public class SmallMartImpl implements SmallMart{

	@Override
	public void getProduct(String name)  {
		System.out.printf("getProduct(%s)%n", name);
	}
	
	public void getProduct2(String name)  {
		System.out.printf("getProduct2(%s)%n", name);
	}
}
