package com.inadang.webtest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //이 어노테이션 덕분에 빈즈로 등록되어있음 ( 얘 주석하면 사라짐)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
					//얘따라감
	@RequestMapping("index")
	public void index(){}
	
	@RequestMapping("nf")
	public String NewFile(){
				//얘따라감
		return "NewFile";	
	}
}
