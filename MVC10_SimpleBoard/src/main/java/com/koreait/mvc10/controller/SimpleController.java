package com.koreait.mvc10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc10.command.SimpleCommand;
import com.koreait.mvc10.command.SimpleDeleteCommand;
import com.koreait.mvc10.command.SimpleInsertCommand;
import com.koreait.mvc10.command.SimpleListCommand;
import com.koreait.mvc10.command.SimpleUpdateCommand;
import com.koreait.mvc10.command.SimpleViewCommand;

@Controller
public class SimpleController {
	private SimpleCommand command; 
	@RequestMapping("/")
	public String goIndex() {
		return "index"; 
	}
	@RequestMapping("list")
	public String goList(Model model ) {
		command = new SimpleListCommand();
		command.execute(model);
		return "simple/listPage";	
	}
	
	@RequestMapping("insertPage")
	public String goInsertPage() {
		return "simple/insertPage";
	}

	@RequestMapping("insert")
	public String goInsert(HttpServletRequest request, Model model) {
		model.addAttribute("req", request);
		command = new SimpleInsertCommand();
		command.execute(model);
		return "redirect:list";
	}
	@RequestMapping("view")
	public String goView(HttpServletRequest request, Model model) {
		//SimpleViewCpmmand 엑 전달할 request를 model에 저장.
		model.addAttribute("request", request);
		command = new SimpleViewCommand();
		command.execute(model);
		return "simple/viewPage";
		
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String goUpdate(HttpServletRequest request, Model model) {
	model.addAttribute("request",request); //command로 보내기
	
	command = new SimpleUpdateCommand();
	command.execute(model);
	
	return "redirect:view?bNo="+request.getParameter("bNo");
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String goDelete(HttpServletRequest request, Model model) {
	model.addAttribute("request", request);
		
	command = new SimpleDeleteCommand();
	command.execute(model);
	
	return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
