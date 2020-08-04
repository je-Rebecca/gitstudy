package com.koreait.finalproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.finalproject.command.BoardCommand;
import com.koreait.finalproject.command.BoardInsertCommand;
import com.koreait.finalproject.command.ListCommand;
import com.koreait.finalproject.command.selectListCommand;



@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlsession; 
	private BoardCommand command; 
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("list")
	public String goList(Model model) {
		command = new ListCommand();
		command.execute(sqlsession, model);
		return "board/list";
	}
	
	@RequestMapping("writePage")
	public String goWritePage(Model model) {
		return "board/writePage";
	}
	@RequestMapping(value="boardInsert", method=RequestMethod.POST)
	public String boardInsert(RedirectAttributes rttr,
			HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		model.addAttribute("rttr", rttr);
		command = new BoardInsertCommand();
		command.execute(sqlsession, model);
		return "redirect: selectList";
	}
	@RequestMapping("selectList")
	public String view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new selectListCommand();
		command.execute(sqlsession, model);
		return "board/view";
	}
	
	@RequestMapping(value ="boardUpdate", method=RequestMethod.POST)
	public String simpleUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new selectListCommand();
		command.execute(sqlsession, model);
		return "redirect: selectList";
	}
	@RequestMapping(value ="boardDelete", method=RequestMethod.POST)
	public String simpleDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new selectListCommand();
		command.execute(sqlsession, model);
		return  "redirect: selectList";
	}
	@RequestMapping("boardInsertPage")
	public String insertPage() {
		return "simple/insertPage";
	}
	
}
