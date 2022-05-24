package com.inadang.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inadang.domain.BoardAttachVO;
import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;
import com.inadang.domain.PageDTO;
import com.inadang.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	//롬복 Data해도 final args 생성해서 빈설정해줌. 
	private final BoardService boardService;
	
	@GetMapping("list")
	public String list(Model model, Criteria cri){
		model.addAttribute("boards", boardService.getList(cri));
		model.addAttribute("page", new PageDTO(boardService.getTotalCount(cri), cri));
		return "/board/list";
	}
	
	@GetMapping("list2") @ResponseBody
	public List<BoardVO> list(@ModelAttribute("cri") Criteria cri){
		return boardService.getList(cri);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("register")
	public void register(Criteria cri){
		//register 메서드명 겹치지만 오버라이딩 해서 얼마든지 사용 가넝
		//아래는 리다이렉트지만 얘는 포워딩할거라 jsp필요
		
	}
					//로그인 되었는지, 해당작성자랑 로그인토큰 값이 같으지
	@PreAuthorize("isAuthenticated() and principal.username == #boardVO.writer")
    @PostMapping("register")
    public String register(BoardVO boardVO, RedirectAttributes rttr, Criteria cri){
        log.info(boardVO);
        boardService.register(boardVO);
        rttr.addFlashAttribute("result", boardVO.getBno());
        rttr.addAttribute("pageNum", 1);
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());
        return "redirect:/board/list";
    }
	
	@GetMapping({"get", "modify"})
	public void get(Long bno, Criteria cri, Model model ){
		model.addAttribute("board", boardService.get(bno));
		model.addAttribute("boards", boardService.get(bno));
		model.addAttribute("cri", cri); //별칭줘서 get.jsp 에 criteria 대신 ${cri}로 검색가능, 안하면 bean이름 따라감
	}
	
	@PreAuthorize("isAuthenticated() and principal.username == #boardVO.writer" )
	@PostMapping("modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr, Criteria cri){
		log.info(cri);
		log.info(boardVO);
		if(boardService.modify(boardVO)){
			rttr.addFlashAttribute("result", "수정");
		}
		return "redirect:/board/list" + cri.getParams();
	}
	
	@PreAuthorize("isAuthenticated() and principal.username == #writer" )
	@PostMapping("remove")																//인스턴스로서의 호출
	public String remove(Long bno, RedirectAttributes rttr,Criteria cri, String writer, UploadController uc){
		log.info(cri);
		List<BoardAttachVO> attachs = boardService.getAttaches(bno);
//		log.info(uc.deleteFile(boardService.get(bno).getAttachs().get(0)));
		if(boardService.remove(bno)){
			rttr.addFlashAttribute("result", "삭제");
			if(attachs != null) attachs.forEach(uc::deleteFile);
//			boardVO.getAttachs().forEach(attach -> uc.deleteFile(attach));
			
		}	
		return "redirect:/board/list" + cri.getParams();
	}
	
	@GetMapping("attachs") @ResponseBody
	public List<BoardAttachVO> getAttaches(Long bno){
		log.info(bno);
		return boardService.getAttaches(bno);
	}
}
