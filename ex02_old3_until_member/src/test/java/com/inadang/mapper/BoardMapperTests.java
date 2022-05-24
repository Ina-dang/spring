package com.inadang.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.BoardVO;
import com.inadang.domain.Criteria;

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
	public void testGetListWithPaging(){
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(5);
//		cri.setType("TW");
//		cri.setKeyword("user");
		log.info(cri);
		
		List<BoardVO> result = boardMapper.getListWithPaging(cri);
		assertNotNull(cri);
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
	
	@Test
	public void testUpdate(){
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(2L);
		boardVO.setTitle("test update");
		boardVO.setContent("test update");
		log.info(boardVO);
		
		int exp = 1;
		
		int result = boardMapper.update(boardVO);
		
		assertEquals("게시글 수정", exp, result);
		log.info(boardVO);
	}
	
	@Test
	public void testGetTotalCount(){
		Criteria cri = new Criteria(); //초기값 부여 후 값 지정
		cri.setPageNum(4);
		cri.setAmount(5);
		cri.setType("TW");
		cri.setKeyword("user");
		log.info(boardMapper.getTotalCount(cri));
	}
	
	@Test
	public void testGetListDynamicTest(){
		Criteria cri = new Criteria();
//		cri.setType("TC");
		log.info(Arrays.toString(cri.getTypeArr()));
//		cri.setType("T");
		cri.setKeyword("테스트");
		boardMapper.getListDynamicTest(cri).forEach(log::info);
	}
	
	@Test
	public void testDelete(){
		Long bno = 4L;
		log.info(bno);
		
		int exp = 1;
		
		int result = boardMapper.delete(bno);
		
		assertEquals("게시글 삭제", exp, result);
		log.info(bno);
	}
	
	@Test
	public void testStringJoin(){
		String[] arr = {"1","21","3","4"};
		log.info(String.join("", arr));
	}
}
