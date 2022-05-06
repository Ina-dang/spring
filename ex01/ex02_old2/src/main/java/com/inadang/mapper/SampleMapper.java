package com.inadang.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper {

	@Insert("INSERT INTO tbl_sample1 VALUES (#{str})")
	int insert1(String str);
	
	@Insert("INSERT INTO tbl_sample2 VALUES (#{str})")
	int insert2(String str);
}
