package edu.biz.constructor;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.biz.constructor.Develope;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class) //이건 거의 고정
@ContextConfiguration("file:src/main/resources/const1.xml") //xml 위치 알려줌
/*@AllArgsConstructor*/ //테스트 코드에서는 안됨
public class DevelopeTests {
	@Setter @Autowired  
	private Develope develope;
	
	@Test
	public void testExist(){
		assertNotNull(develope);
	}
	@Test
	public void testCoding(){
		develope.coding();
	}
}
