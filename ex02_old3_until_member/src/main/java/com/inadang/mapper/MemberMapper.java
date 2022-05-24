package com.inadang.mapper;

import com.inadang.domain.AuthVO;
import com.inadang.domain.MemberVO;

public interface MemberMapper {
	
	MemberVO read(String userid);
	
	int insertMember (MemberVO vo);
	
	int insertAuth(AuthVO vo);
	
}
