package edu.biz.spel2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter @Slf4j
public class HumanApp2 {
	private Map<String, Object> map;
	private Set<String> set;
	private List<String> list;
	private Properties properties;
	
	public static void main(String[] args) {
		HumanApp2 humanapp2= new ClassPathXmlApplicationContext("human2.xml")
				.getBean("humanApp2", HumanApp2.class);
		
		log.info("-------list-----------");
		humanapp2.list.forEach(log::info);
		
		log.info("-------set-----------");
		humanapp2.set.forEach(log::info);
		
		log.info("-------map-----------");
//		humanapp2.map.forEach(log::info); //인자 2개필요
		humanapp2.map.forEach((k,v)->log.info(String.format("%s :: %s", k,v)));
		
		log.info("-------properties-----------");
//		humanapp2.map.forEach(log::info); //인자 2개필요 (Biconsumer)
		humanapp2.properties.forEach((k,v)->log.info(String.format("%s :: %s", k,v)));
	}
}
