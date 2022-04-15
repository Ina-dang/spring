package com.inadang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter @Autowired
	private BoardService boardService;
	
	@Test
	public void testExist(){
		assertNotNull(boardService);
	}
	
	@Test
	public void testGetList(){
		List<BoardVO> result = boardService.getList();
		assertNotNull(result);
		result.forEach(log::info);
	}
	
	@Test
	public void testGet(){
		BoardVO result = boardService.get(2L);
		assertNotNull(result);
		log.info(result);
	}
	
	@Test
	public void testRegister(){
		//init
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("inadang");
		
		//expect
		log.info(board);
		
		int exp = 1;
		
		//result
		int result = boardService.register(board);
		
		assertEquals("게시글추가", exp, result);
		
		log.info(board);
	}
	
	@Test
	public void testModify(){
		BoardVO boardVO = boardService.get(48L);
		log.info(boardVO);
		boardVO.setTitle("service test modify");
		log.info(boardVO);
		
		boolean exp = true;
		
		boolean result = boardService.modify(boardVO);
		
		assertEquals("게시글수정", exp, result);
		log.info(boardVO);
	}
	
	@Test
	public void testDelete(){
		Long bno = 59L;
		log.info(bno);
		
		boolean exp = true;
		
		boolean result = boardService.remove(bno);
		
		assertEquals("게시글삭제", exp, result);
	}
	
	
}
