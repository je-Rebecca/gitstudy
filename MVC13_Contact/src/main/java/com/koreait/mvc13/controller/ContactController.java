package com.koreait.mvc13.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc13.command.ContactCommand;
import com.koreait.mvc13.command.ContactDeleteCommand;
import com.koreait.mvc13.command.ContactInsertCommand;
import com.koreait.mvc13.command.ContactListCommand;
import com.koreait.mvc13.command.ContactUpdateCommand;
import com.koreait.mvc13.command.contactViewCommand;
import com.koreait.mvc13.common.Constant;

@Controller
public class ContactController {
	
	ContactCommand command; 
	
	private JdbcTemplate template;
	@Autowired  
	public void abc(JdbcTemplate template) {
		this.template= template; 
		Constant.template = this.template; 
	}
	
	@RequestMapping("/")
public String goIndex() {
		return "index";
	}
	@RequestMapping("contactListPage")
	public String goContact(Model model) {
		command = new ContactListCommand();
		command.execute(model);
		return "contact/contactListPage";
	}
	@RequestMapping("contactViewPage")
	public String contactViewPage(HttpServletRequest request,Model model) {
		model.addAttribute("request", request); 
		command = new contactViewCommand();
		command.execute(model);
		return "contact/contactViewPage"; 
	}
	@RequestMapping("contactInsertPage")
	public String contactInsertPage() {
		return "contact/contactInsertPage"; 
	}
	@RequestMapping(value ="contactInsert", method=RequestMethod.POST)
	public String contatctInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new ContactInsertCommand();
		command.execute(model);
		return "redirect:contactListPage";
	}
	@RequestMapping(value ="contactDelete", method=RequestMethod.POST)
	public String contactDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new ContactDeleteCommand();
		command.execute(model);
		return "redirect:contactListPage"; 
	}
	@RequestMapping(value ="contactUpdate", method=RequestMethod.POST)
	public String contactUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command= new ContactUpdateCommand();
		command.execute(model);
		return "redirect:contactViewPage";
	}
}


