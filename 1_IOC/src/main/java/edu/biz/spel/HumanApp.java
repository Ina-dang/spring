package edu.biz.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service @Setter @Slf4j
public class HumanApp {
	@Value("${human.name}")
	private String name;
	@Value("#{human.age}")
	private int age;
	
//	@Value("#{human}")
	@Autowired
	private Human human;
	
	
	public static void main(String[] args) {
		HumanApp humanapp= new ClassPathXmlApplicationContext("human.xml")
				.getBean("humanApp", HumanApp.class);
		log.info(humanapp.name);
		log.info(humanapp.age + ""); //기본ㄴ이 스트링이라 스트링처리해줘야함
		log.info(humanapp.human.getName());
		log.info(humanapp.human.getAge() + "");
	}
}
