package edu.biz.magic;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Tiger implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return "난 호랑이다 어훙~";
	}

}
