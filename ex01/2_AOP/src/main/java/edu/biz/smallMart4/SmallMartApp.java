package edu.biz.smallMart4;

import lombok.Setter;

public class SmallMartApp {
	@Setter
	private SmallMartImpl martImpl;
	
	public void run(){
		martImpl.getPruduct("와아");
	}
	
}
