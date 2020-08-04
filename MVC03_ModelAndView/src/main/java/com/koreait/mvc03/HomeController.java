package com.koreait.mvc03;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//Model and View 클래스 Spring 2 이전 사용. (요즘은 안씀) 
	@RequestMapping("v01") // 실제 이동할 페이지와 Mapping값이 일치하지 않아 보안에 유리 다른방법, 데이터베이를 다른곳에 설치한다. 
	public ModelAndView goView01() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view01");
		
		return mav;
	}
	
	@RequestMapping("/v02")
	public ModelAndView goView02() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("country", "S.Korea");
		mav.addObject("capital", "Seoul");
		mav.setViewName("board/view02");
		return mav;
	}
	
	
	
	
	
}
