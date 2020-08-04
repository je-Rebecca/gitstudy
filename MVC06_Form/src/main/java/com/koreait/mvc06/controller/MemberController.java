package com.koreait.mvc06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc06.dto.MemberDTO;

@Controller
public class MemberController {
	@RequestMapping("index")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(value ="member/login", method=RequestMethod.GET) 
	public String goLoginResult(@RequestParam("id") String id,
								@RequestParam("pw") String pw, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "member/loginResult";
		
	}
	@RequestMapping(value ="member/login2", method=RequestMethod.POST)
	public String goLoginResult2(MemberDTO mDTO, Model model) {
		model.addAttribute("mDTO", mDTO);
		return "member/loginResult2";
	}
	/*@RequestMapping(value ="member/login2", method=RequestMethod.POST)
	public String goLoginResult2(@ModelAttribute("mDTO") MemberDTO mDTO ) {
		return "member/loginResult2";
	}*/
}
