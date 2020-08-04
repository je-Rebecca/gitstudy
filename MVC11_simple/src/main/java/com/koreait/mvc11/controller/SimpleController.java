package com.koreait.mvc11.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc11.command.SimpleDeleteCommand;
import com.koreait.mvc11.command.SimpleInsertCommand;
import com.koreait.mvc11.command.SimpleListCommand;
import com.koreait.mvc11.command.SimpleUpdateCommand;
import com.koreait.mvc11.command.SimpleViewCommand;
import com.koreait.mvc11.dto.SimpleDTO;
@Controller
public class SimpleController {
	//Field
	private SimpleListCommand simpleListCommand;
	private SimpleViewCommand simpleViewCommand;
	private SimpleDeleteCommand simpleDeleteCommand;
	private SimpleInsertCommand simpleInsertCommand;
	private SimpleUpdateCommand simpleUpdateCommand;
	
	//메소드 @Autowired 한번만 사용하기위해 
	@Autowired
	public void abcd(SimpleListCommand simpleListCommand,
			SimpleViewCommand simpleViewCommand,
			SimpleDeleteCommand simpleDeleteCommand,
			SimpleInsertCommand simpleInsertCommand,
			SimpleUpdateCommand simpleUpdateCommand) {
		this.simpleListCommand = simpleListCommand;
		this.simpleViewCommand = simpleViewCommand;
		this.simpleDeleteCommand = simpleDeleteCommand;
		this.simpleInsertCommand = simpleInsertCommand;
		this.simpleUpdateCommand = simpleUpdateCommand;
	}
	
	@RequestMapping("/")
	public String goIndex() {return "index"; }
	
	@RequestMapping("list")
	public String goList(Model model) {
		simpleListCommand.execute(model);
		return "simple/listPage"; 
	}
	@RequestMapping("view")
	public String view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		simpleViewCommand.execute(model);
		return "simple/viewPage";
	}
	@RequestMapping(value ="update", method =RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		simpleUpdateCommand.execute(model);
		return "redirect:view";
	}
	@RequestMapping(value ="delete", method =RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
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
		model.addAttribute("sDTO", sDTO);
		simpleInsertCommand.execute(model);
		return "redirect:list";
		
	}
}




















