package com.koreait.mvc07.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc07.dto.StudentDTO;

@Controller
public class StudentController { 
	@RequestMapping(value ="v01", method=RequestMethod.GET)
	public String goView01(StudentDTO sDTO, Model model) {
		model.addAttribute("sDTO", sDTO);
		return "student/result01";
	}//forward
	@RequestMapping(value ="v02", method=RequestMethod.POST)
	public String goView02(StudentDTO sDTO, RedirectAttributes rttr) {
		rttr.addFlashAttribute("sDTO", sDTO);
		return "redirect:v03";  
	}//redirect 
	@RequestMapping("v03")
	public String goView03() {
		return "student/result02";
	}
}
