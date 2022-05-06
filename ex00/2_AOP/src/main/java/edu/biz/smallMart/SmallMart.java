package edu.biz.smallMart;

public interface SmallMart {
	//예외 발생할 수 있게 사전처리
	void getProduct(String name) throws Exception;
}
