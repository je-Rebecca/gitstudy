package com.koreait.mvc12.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc12.command.SimpleCommand;
import com.koreait.mvc12.command.SimpleDeleteCommand;
import com.koreait.mvc12.command.SimpleInsertCommand;
import com.koreait.mvc12.command.SimpleListCommand;
import com.koreait.mvc12.command.SimpleUpdateCommand;
import com.koreait.mvc12.command.SimpleViewCommand;
import com.koreait.mvc12.config.AnnoCTX;
import com.koreait.mvc12.dto.SimpleDTO;
@Controller
public class SimpleController {
	//Field
	private AnnotationConfigApplicationContext	ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	
	@RequestMapping("/")
	public String goIndex() {return "index"; }
	
	@RequestMapping("list")
	public String goList(Model model) {
		SimpleCommand simpleListCommand = ctx.getBean("simpleListCommand", SimpleListCommand.class);
		simpleListCommand.execute(model);
		return "simple/listPage"; 
	}
	@RequestMapping("view")
	public String view(HttpServletRequest request, Model model) {
		SimpleViewCommand simpleViewCommand = ctx.getBean("simpleViewCommand", SimpleViewCommand.class);
		model.addAttribute("request",request);
		simpleViewCommand.execute(model);
		return "simple/viewPage";
	}
	@RequestMapping(value ="update", method =RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		SimpleUpdateCommand simpleUpdateCommand = ctx.getBean("simpleUpdateCommand", SimpleUpdateCommand.class);
		model.addAttribute("request",request);
		simpleUpdateCommand.execute(model);
		return "redirect:view";
	}
	@RequestMapping(value ="delete", method =RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
		SimpleDeleteCommand simpleDeleteCommand = ctx.getBean("simpleDeleteCommand", SimpleDeleteCommand.class);
		model.addAttribute("request",request);
		simpleDeleteCommand.execute(model);
		return "redirect:list";
	}
	@RequestMapping("insertPage")
	public String goInertPage() {
		return "simple/insertPage";
	}
	@RequestMapping("insert")
	public String insert(SimpleDTO sDTO, Model model) {
		SimpleInsertCommand simpleInsertCommand = ctx.getBean("simpleInsertCommand", SimpleInsertCommand.class);
		model.addAttribute("sDTO", sDTO);
		simpleInsertCommand.execute(model);
		return "redirect:list";
		
	}
}




















