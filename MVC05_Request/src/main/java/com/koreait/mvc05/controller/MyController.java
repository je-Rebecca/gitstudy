package com.koreait.mvc05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc05.dto.PersonDTO;

@Controller
public class MyController {
	@RequestMapping("member/v01")
	public String goView01(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		int age= Integer.parseInt(request.getParameter("age")); 
		model.addAttribute("name", name);
		model.addAttribute("age",age);
		
		return "member/view01";  //  WEB-NF/views/member/view01.jsp
	}

	//Spring 스타일 
	@RequestMapping("member/v02")
	public String goView02(@RequestParam("name") String name, 
							@RequestParam("age") int age, Model model	) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "member/view02"; 
	}
	@RequestMapping("member/v03")
	public String goView03(@RequestParam("name") String name, 
							@RequestParam("age") int age, Model model) {
		PersonDTO pDTO = new PersonDTO();
		pDTO.setName(name);
		pDTO.setAge(age);
		model.addAttribute("pDTO",pDTO);
		return "member/view03";
	}
	@RequestMapping("member/v04")
	public String goView04(PersonDTO pDTO, Model model) {
		model.addAttribute("pDTO",pDTO);
		return "member/view04";
	}
	@RequestMapping("member/v05")
	public String goView05(@ModelAttribute("pDTO") PersonDTO pDTO) {
		return "member/view05";
	}
}
