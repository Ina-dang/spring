package com.inadang.service;

import java.util.List;

import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;

//199
public interface BoardService {
	int register(BoardVO boardVO);
	
	BoardVO get (Long bno);
	
	boolean modify(BoardVO boardVO);
	
	boolean remove(Long bno);
	
	public List<BoardVO> getList(Criteria cri) ;

	int getTotalCount(Criteria cri);
	//스프링 마이바티스가 mapper클래스에서는 대신해줬음
}
