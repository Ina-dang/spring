package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.domain.CriteriaReply;
import com.inadang.domain.ReplyVO;
import com.inadang.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	private ReplyMapper mapper;
	@Override
	public int register(ReplyVO vo) {
		return mapper.insertSelectKey(vo);
	}

	@Override
	public ReplyVO get(long rno) {
		// TODO Auto-generated method stub
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(long bno, CriteriaReply cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(bno, cri);
	}
}
