package edu.biz.setter1;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter @Slf4j 
public class Develope {
	@Inject 
	private Emp emp;
	
	void coding(){
		emp.gotoOffice();
		log.info("개발합니다..");
		emp.getofffWork();
	}
}
