package com.koreait.mvc09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mvc09.calculator.Calculator;

@Controller
public class MyController {
@RequestMapping("v01")
	public String goView1(Calculator cal, Model model) {
	model.addAttribute("cal", cal);
	return "view1";
	}

@RequestMapping("v02")
	public String goView2(Calculator cal, Model model) {
	model.addAttribute("cal", cal);
	return "view2";
	}

}
