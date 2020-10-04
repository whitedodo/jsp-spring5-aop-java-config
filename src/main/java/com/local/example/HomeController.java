/*
 * 	주제(Subject): AOP 프로그래밍(Aspect-Oriented Programming)
 *  파일명(Filename): HomeController.java
 *  생성일자(Created Date): 2020-10-04
 *  저자(Author): Dodo(rabbit.white@daum.net)
 *  설명(Description):
 * 
 * 	1. 관점지향 프로그래밍 소개
 * 
 */
package com.local.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.local.example.aop.Calculator;
import com.local.example.aop.RootConfig;

/**
 * Handles requests for the application home page.
 */
@EnableAspectJAutoProxy
@Controller
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
		
		// Java 방식 - AOP
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		// 1. 이전 방식
		// Calculator cal = new Calculator(1, 2, 3);

		// 2. Aspect 적용
		// 소문자로 입력(Calculator -> calculator로)
		Calculator cal = (Calculator)context.getBean("cal", Calculator.class);
		System.out.printf("result of sum: %d", cal.sum());
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
