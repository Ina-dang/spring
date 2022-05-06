package com.inadang.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inadang.domain.CriteriaReply;
import com.inadang.domain.ReplyVO;
import com.inadang.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("replies")
@AllArgsConstructor
@Log4j
public class ReplyController {
	private ReplyService service;
	
	@PostMapping ("new")
	public Long create(@RequestBody ReplyVO vo){
		log.info(vo);
		return service.register(vo) > 0 ? vo.getRno() : null;
	}
									
	@GetMapping({"pages/{bno}", "pages/{bno}/{lastRno}" ,"pages/{bno}/{lastRno}/{amount}"})
	public List<ReplyVO> getList(
			@PathVariable Long bno, //true가 기본값
			@PathVariable(required=false) Optional<Long> lastRno, 
			@PathVariable(required=false) Optional<Integer> amount){
		CriteriaReply cri = new CriteriaReply();
		cri.setLastRno(lastRno.orElse(cri.getLastRno()));
		cri.setAmount(amount.orElse(cri.getAmount()));
		return service.getList(bno, cri);
	}
	
	@GetMapping("{rno}")
	public ReplyVO get(@PathVariable Long rno){
		return service.get(rno);
	}
	
	@DeleteMapping("{rno}")
	public String remove(@PathVariable Long rno){
		return service.remove(rno) > 0 ? "success" : null;
	}
	
	@RequestMapping(value="{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public String modify(@PathVariable Long rno, @RequestBody ReplyVO vo){
		return service.modify(vo) > 0 ? "success" : null;
	}
}
