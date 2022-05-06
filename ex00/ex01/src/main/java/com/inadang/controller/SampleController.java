package com.inadang.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inadang.domain.Board;
import com.inadang.domain.Criteria;
import com.inadang.domain.SampleDTO;
import com.inadang.domain.SampleDTOList;
import com.inadang.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
					//복수로 할때는 배열형태로
@RequestMapping({"/sample/*", "/sample"})
@Log4j
public class SampleController {
					//이넘				겟방식형식
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req, HttpSession session, Board board){
		log.info("basic................");
		log.info(req);
		log.info(req.getSession());
		log.info(session);
		log.info(board);
	}
	
	@GetMapping("get") @PostMapping("get")
	public void basic2(){
		log.info("basic2..................");
	}
	
	@GetMapping("ex01")
	public String ex01(SampleDTO dto){
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("ex02")
	public String ex02(String name, @RequestParam(value = "myAge", required=false) int age){
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
	
	@GetMapping("ex02List")
	public void ex02list(@RequestParam("ids") ArrayList<String> ids){
		log.info(ids);
	}
	@GetMapping("ex02Set")
	public void ex02Set(@RequestParam("ids") HashSet<String> ids){
		log.info(ids);
	}
	@GetMapping("ex02Array")
	public void ex02Array(@RequestParam("ids") String[] ids){
		log.info(Arrays.toString(ids));
	}
	
	@GetMapping("cri")
	public void cri(Criteria criteria , Board board){
		log.info(criteria);
		log.info(board);
	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list){
		log.info("list dtos: " + list);
		return "ex02Bean";
	}
	
	@GetMapping("ex03")
	public void ex03(TodoDTO todo){
		log.info("todo : " + todo);
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
//	}
	
	
	
	@GetMapping("ex04")
	public void ex04(SampleDTO dto, @ModelAttribute("page") int page, Model model){
		log.info(dto);
		log.info(page);
		model.addAttribute("amount", 25);
	}
	
	@GetMapping("ex04Rttr")
	public String ex04Rttr(RedirectAttributes rttr, Criteria cri){
//		rttr.addAttribute("page", "4");
		rttr.addFlashAttribute("page", 4);
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:ex04";
	}
	
	@GetMapping("ex05") @ResponseBody
	public Criteria ex05(){
		return new Criteria();
	}
	@GetMapping("ex05_1") @ResponseBody
	public Board ex05_1(Board board){
		return board;
	}
	
	@GetMapping("ex05_2") @ResponseBody
	public List<SampleDTO> ex05_2(){
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		List<SampleDTO> list = new ArrayList<>();
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		return list;
	}
	
	@GetMapping("ex07")
	public ResponseEntity<String> ex07(){
		log.info("ex07...............");
		String msg = "{\name\":\"홍길동\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF=8");
		
		return new ResponseEntity<>(msg, headers, HttpStatus.OK);
	}
	
	@GetMapping("exUpload")
	public void exUpload(){
		log.info("exUpload.......");
	}
	
//	두포스트처리
	@PostMapping("exUpload")
	public void exUploadPost(ArrayList<MultipartFile> files){
		log.info("exUploadPost.......");
		files.forEach(file -> {
			log.info("==============");
			log.info("name : " + file.getOriginalFilename());
			log.info("name : " + file.getSize());
		});
	}
}
