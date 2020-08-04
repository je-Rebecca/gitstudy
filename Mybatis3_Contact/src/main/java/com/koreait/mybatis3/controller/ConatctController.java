package com.koreait.mybatis3.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mybatis3.command.ContactCommand;
import com.koreait.mybatis3.command.ContactDeleteCommand;
import com.koreait.mybatis3.command.ContactInsertCommand;
import com.koreait.mybatis3.command.ContactListCommand;
import com.koreait.mybatis3.command.ContactUpdateCommand;
import com.koreait.mybatis3.command.ContactViewCommand;

@Controller
public class ConatctController {
@Autowired
private SqlSession ss; 
private ContactCommand command;
	
@RequestMapping("/")
public String goindex() {
	return "index";
}
@RequestMapping("contactListPage")
public String listPage(Model model) {
	command = new ContactListCommand();
	command.execute(ss, model);
	return"contact/contactListPage";
}
@RequestMapping("contactViewPage")
public String simpleViewPage(HttpServletRequest request,
							 Model model) {
	model.addAttribute("request", request);
	command = new ContactViewCommand();
	command.execute(ss, model);
	return "contact/contactViewPage";
}

@RequestMapping(value="contactUpdate", method=RequestMethod.POST)
public String simpleUpdate(HttpServletRequest request,
						   Model model) {
	model.addAttribute("request", request);
	command = new ContactUpdateCommand();
	command.execute(ss, model);
	return "redirect:contactViewPage";
}

@RequestMapping(value="contactDelete", method=RequestMethod.POST)
public String simpleDelete(HttpServletRequest request,
		   				   Model model) {
	model.addAttribute("request", request);
	command = new ContactDeleteCommand();
	command.execute(ss, model);
	return "redirect:contactListPage";
}

@RequestMapping("contactInsertPage")
public String simpleInsertPage() {
	return "contact/contactInsertPage";
}

@RequestMapping(value="contactInsert", method=RequestMethod.POST)
public String simpleInsert(HttpServletRequest request,
						   Model model) {
	model.addAttribute("request", request);
	command = new ContactInsertCommand();
	command.execute(ss, model);
	return "redirect:contactListPage";
}


}
