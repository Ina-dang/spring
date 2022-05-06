package edu.biz.constructor;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
public class Designer implements Emp{

	@Override
	public void gotoOffice() {
		log.info("디자이너 출근합니다.");
	}

	@Override
	public void getofffWork() {
		log.info("디자이너 퇴근합니다.");
	}
}
