package com.koreait.mybatis2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.command.SimpleCommand;
import com.koreait.mybatis2.command.SimpleDeleteCommand;
import com.koreait.mybatis2.command.SimpleInsertCommand;
import com.koreait.mybatis2.command.SimpleListCommand;
import com.koreait.mybatis2.command.SimpleUpdateCommand;
import com.koreait.mybatis2.command.SimpleViewCommand;

@Controller
public class SimpleController {
	@Autowired
	private SqlSession ss; 
	private SimpleCommand simpleCommand;
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("simpleListPage")
	public String simpleListPage(Model model) {
		simpleCommand = new SimpleListCommand();
		simpleCommand.excute(ss, model);
		return "simple/listPage"; 
	}
	@RequestMapping(value="simpleInsert",method=RequestMethod.POST)
	public String simpleInsert(RedirectAttributes rttr,
			HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("rttr", rttr);
		simpleCommand = new SimpleInsertCommand();
		simpleCommand.excute(ss, model);
		return "redirect:simpleListPage";
	}
	
	@RequestMapping("simpleViewPage")
	public String simpleViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleCommand = new SimpleViewCommand();
		simpleCommand.excute(ss, model);
		return "simple/viewPage";
	}
	@RequestMapping(value ="simpleUpdate", method=RequestMethod.POST)
	public String simpleUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleCommand = new SimpleUpdateCommand();
		simpleCommand.excute(ss, model);
		return "redirect:simpleViewPage";
	}
	@RequestMapping(value ="simpleDelete", method=RequestMethod.POST)
	public String simpleDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		simpleCommand = new SimpleDeleteCommand();
		simpleCommand.excute(ss, model);
		return  "redirect:simpleListPage";
	}
	@RequestMapping("simpleInsertPage")
	public String insertPage() {
		return "simple/insertPage";
	}
	
		
	
}
