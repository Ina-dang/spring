package edu.biz.magic;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.biz.constructor.Develope;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class) //이건 거의 고정
@ContextConfiguration("/magic.xml") //xml 위치 알려줌
/*@AllArgsConstructor*/ //테스트 코드에서는 안됨
public class MagicianTests {
	@Setter @Inject  
	private Magician magician;
	
	@Test
	public void testExist(){
		assertNotNull(magician);
	}
	@Test
	public void testCoding(){
		magician.magic();
	}
}
