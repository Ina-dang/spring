package com.inadang.webtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.webtest.dao.BoardDao;
import com.inadang.webtest.domain.Board;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class BoardService {
	private BoardDao dao;
	
	public List<Board> list(){
		return dao.list();
	}
}
