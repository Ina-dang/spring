package com.inadang.service;

import java.util.List;

import com.inadang.domain.CriteriaReply;
import com.inadang.domain.ReplyVO;

public interface ReplyService {
	int register(ReplyVO vo);
	
	ReplyVO get(long rno);
	
	int modify(ReplyVO vo);
	
	int remove(Long rno);
	
	List<ReplyVO> getList(long bno, CriteriaReply cri);
}
