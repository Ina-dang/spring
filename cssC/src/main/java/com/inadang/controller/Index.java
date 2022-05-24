package com.inadang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("board/*")
public class Index {
	
	@GetMapping("index")
	public void index(){
		
	}
	@GetMapping("payments")
	public void payments(){
		
	}
}
