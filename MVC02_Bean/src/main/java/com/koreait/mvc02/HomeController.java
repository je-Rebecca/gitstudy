package com.koreait.mvc02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Handles requests for the application home page.*/
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/** Simply selects the home view to render by returning its name.*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}  //주소창에 http://localhost:9090/mvc02/a/b/c/d/e 가 입력되면 view.jsp로 이동. 
	@RequestMapping("/a/b/c/d/e")
	public String goView01() {//타입은 항상 String view 리턴 하니 | 메소드 이름 의미 x
		return "view01";  
		//return "/view01"; 둘다 가능.  
	}
	@RequestMapping("loginPage")
	public String goLogin() {
		return "member/loginPage";
	}
	@RequestMapping("view02")
	public String goView02(Model model) {
		model.addAttribute("name", "Emma");// 실제 저장되는 곳 request. 
		model.addAttribute("age", "20");
		return "view02";  //WEB-INF/views/view02.jsp로 이동 
	}
	@RequestMapping("view03")  //view03으로 가면 PersonDTO, cotactDTO 정보 확인가능
	public String goView03() {
		return "view03";
	}
}
