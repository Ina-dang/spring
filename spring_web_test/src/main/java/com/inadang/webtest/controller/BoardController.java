package com.inadang.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inadang.webtest.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("board") 
@AllArgsConstructor
public class BoardController {
	//서비스 인스턴스 생성
	// 서비스 list 반환 >> req.attribute()바인딩
	// list.jsp 포워딩
	
	private BoardService boardService;
	
	
	//board/list
	@RequestMapping("list")
	public void list(Model model){
		model.addAttribute("list", boardService.list());
	}
}
