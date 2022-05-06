package com.inadang.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.AuthVO;
import com.inadang.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
	})
@Log4j
public class MemberMapperTests {
	@Setter @Autowired
	private PasswordEncoder encoder;
	
	@Setter @Autowired
	private MemberMapper mapper;
	
	@Test
	public void testInsertMember(){
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("admin99");
		memberVO.setUserpw(encoder.encode("1234"));
		memberVO.setUsername("관리자");
		
		log.info(memberVO);
		
		mapper.insertMember(memberVO);
	}
	
	@Test
	public void testInsertAuth(){
		AuthVO vo = new AuthVO();
		vo.setUserid("admin99");
//		vo.setAuth("ROLE_MEMBER");
//		vo.setAuth("ROLE_MANAGER");
		vo.setAuth("ROLE_ADMIN");
		
		log.info(vo);
		mapper.insertAuth(vo);
	}
	
	@Test
	public void testRead(){
//		mapper.read("admin99");
		log.info(mapper.read("admin99"));
	}
}
