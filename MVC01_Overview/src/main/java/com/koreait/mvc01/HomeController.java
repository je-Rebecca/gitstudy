package com.koreait.mvc01;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/** Handles requests for the application home page. */
@Controller
public class HomeController {
	//로그찍어줌 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/** Simply selects the home view to render by returning its name. */
	@RequestMapping(value = "/", method = RequestMethod.GET)   //url 패턴값. 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); //뷰로 전달하는 값. 
		
		return "home"; //view 리턴  home.jsp로 가라  실제로 리턴되는건 "WEB-INF/views/home.jsp";
		//servlet-context.xml에서 viewResolver가 정해놓은 값.
	}
}
