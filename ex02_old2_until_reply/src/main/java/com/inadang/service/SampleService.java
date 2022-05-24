package com.inadang.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.mapper.SampleMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional()
public class SampleService {
	private SampleMapper mapper;
	
	public void test(String str){
		mapper.insert1(str);
		mapper.insert2(str);
	}

	public void test1(String str){
		mapper.insert1(str);
		mapper.insert2(str);
	}
}
