package com.inadang.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inadang.domain.BoardVO;
import com.inadang.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("board/*")
@AllArgsConstructor
public class BoardController {
	//롬복 Data해도 final args 생성해서 빈설정해줌. 
	private final BoardService boardService;
	
	@GetMapping("list")
	public void list(Model model){
		model.addAttribute("boards", boardService.getList());
	}
	
	@GetMapping("list2") @ResponseBody
	public List<BoardVO> list(){
		return boardService.getList();
	}
	
	
	@PostMapping("register")
	public String register(BoardVO boardVO, RedirectAttributes rttr){
		boardService.register(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("get")
	public void get(Long bno, Model model ){
		model.addAttribute("board", boardService.get(bno));
	}
	
	@PostMapping("modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr){
		if(boardService.modify(boardVO)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("remove")
	public String remove(Long bno, RedirectAttributes rttr){
		if(boardService.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
