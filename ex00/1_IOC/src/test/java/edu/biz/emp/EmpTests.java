package edu.biz.emp;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.biz.getter.Emp;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class) //이건 거의 고정
@ContextConfiguration("/emp.xml") //xml 위치 알려줌
/*@AllArgsConstructor*/ //테스트 코드에서는 안됨
public class EmpTests {
	@Setter @Inject @Qualifier("emp")
	private Emp emp;
	
	@Test
	public void testExist(){
		assertNotNull(emp);
	}
	@Test
	public void testCoding(){
		emp.work();
	}
}
