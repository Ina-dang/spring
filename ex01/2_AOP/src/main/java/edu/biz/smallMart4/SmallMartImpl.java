package edu.biz.smallMart4;

public class SmallMartImpl implements SmallMart{

	@Override
	public void getPruduct(String name) {
		System.out.printf("getProduct(%s)%n", name);
	}
}
