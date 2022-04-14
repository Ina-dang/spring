package com.inadang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inadang.domain.BoardVO;
import com.inadang.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService boardService;
	
	@PostMapping("register")
	public void register(BoardVO boardVO){
		boardService.register(boardVO);
		//redirect
	}
}
