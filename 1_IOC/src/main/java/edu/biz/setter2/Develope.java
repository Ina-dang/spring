package edu.biz.setter2;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter @Slf4j @Service
public class Develope {
	@Inject @Qualifier("designer")
	private Emp emp;
	
	void coding(){
		emp.gotoOffice();
		log.debug("디버그");
		log.info("개발합니다..");
		log.warn("경고");
		log.error("에러");
		log.trace("트레이스");
		emp.getofffWork();
	}
}
