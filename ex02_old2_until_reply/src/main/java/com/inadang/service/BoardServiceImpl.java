package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;
import com.inadang.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service @AllArgsConstructor @Log4j
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	
	@Override
	public int register(BoardVO boardVO) {
		log.info("register(" + boardVO + ")");
		return boardMapper.insertSelectKey(boardVO);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		return boardMapper.update(boardVO) > 0;
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}
	
	
}
