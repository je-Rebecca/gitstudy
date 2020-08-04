package com.koreait.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.rest.dto.PersonDTO;

@RestController
public class RestController2 {

	//request (파라미터) 처리 
	//Rest 방식에서는 URI경로의 일부를 파라미터로 사용 
	@GetMapping(value="user/{id}")
	public String getId(@PathVariable("id") String id) {
		return id; 
	}
	@GetMapping(value ="product/{category}/pno/{pno}")
	public String getProduct(@PathVariable("category") String category,
			@PathVariable("pno") int pno) {
		String product ="category:" + category + ", pno"+ pno; 
		return product;
	}
	//RequestBody 
	@PostMapping(value="person", 
			produces="application/json; charset=utf-8")
	public PersonDTO getDto(@RequestBody PersonDTO pDTO) {
		return pDTO;
	}
}

























