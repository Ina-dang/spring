package com.inadang.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
public class BoardMapperTests {
	@Setter @Autowired
	private BoardMapper boardMapper;
	
	@Test 
	public void testExist(){
		assertNotNull(boardMapper);
	}
	
	@Test
	public void testGetList(){
		List<BoardVO> result = boardMapper.getList();
		assertNotNull(result);
		result.forEach(log::info);
	}
	
	@Test
	public void TestRead(){
		BoardVO result = boardMapper.read(3L);
		assertNotNull(result);
		log.info(result);
	}
	
	//191테스트
	@Test
	public void testInsert(){
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		log.info(board);
		
		int exp = 1;
		int result = boardMapper.insert(board);
		
		assertEquals("게시글추가", exp, result);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey(){
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		log.info(board);
		
		int exp = 1;
		int result = boardMapper.insertSelectKey(board);
		
		assertEquals("게시글추가", exp, result);
		
		log.info(board);
	}
}
