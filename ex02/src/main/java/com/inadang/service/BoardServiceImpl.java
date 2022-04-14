package com.inadang.service;

import org.springframework.stereotype.Service;

import com.inadang.domain.BoardVO;
import com.inadang.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	
	@Override
	public int register(BoardVO boardVO) {
		return boardMapper.insertSelectKey(boardVO);
	}
}
