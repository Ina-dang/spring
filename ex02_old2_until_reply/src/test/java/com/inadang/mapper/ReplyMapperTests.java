package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.CriteriaReply;
import com.inadang.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired @Setter
	private ReplyMapper mapper;
	
//	84082
//	84068
//	84066
//	84064
//	84043
	
	@Test
	public void  testExist(){
		assertNotNull(mapper);
		log.info(mapper);
	}
	
	@Test
	public void testInsert(){
		ReplyVO vo = new ReplyVO();
		vo.setBno(84082L);
		vo.setReply("댓글내용");
		vo.setReplyer("작성자");
		mapper.insert(vo);
	}
	
	@Test
	public void testCreate(){
		Long[] bnoArr = {
				84082L,
				84068L,
				84066L,
				84064L,
				84043L};
		IntStream.rangeClosed(1,  100).forEach(r->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(84082L);
			vo.setReply("댓글내용");
			vo.setReplyer("작성자");
			mapper.insert(vo);
		});
	}
	
	@Test 
	public void testRead(){
		ReplyVO replyVO = mapper.read(20L);
		log.info(replyVO);
	}
	
	@Test
	public void testDelete(){
		mapper.delete(2L);
	}
	@Test
	public void testUpdate(){
		ReplyVO vo = mapper.read(1L);
		vo.setReply("수정된내용");
		
		mapper.update(vo);
	}
	
	@Test
	public void testList(){
		CriteriaReply criteriaReply = new CriteriaReply();
		criteriaReply.setLastRno(10L);
		mapper.getListWithPaging(84082L, new CriteriaReply());
	}
}
