package com.koreait.mvc08.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String goIndex() {
		return "index"; 
	}
	
	@RequestMapping(value="textHandler", produces="text/html")
	@ResponseBody 
	public String text(@RequestParam("sender") String sender)  {
		String receiver = "Hanna";
		String message ="from " +receiver +" to "+sender;
		return message;
	}
	
	@RequestMapping(value="jsonHandler", produces="applocation/json; charset=utf-8")
	@ResponseBody
	public String json(@RequestParam("sender") String sender) {
		String receiver = "Tom";
		JSONObject obj = new JSONObject();
		obj.put("sender", sender);
		obj.put("receiver", receiver);
		return obj.toJSONString();
	}
	
}
