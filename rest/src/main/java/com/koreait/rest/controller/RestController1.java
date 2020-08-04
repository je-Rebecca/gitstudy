package com.koreait.rest.controller;
/* rest 방식의 주요 애너테이션 
 * @RestController 
 * @RequestBody 
 * @ResponseBody 
 *  
 *  */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.koreait.rest.dto.PersonDTO;

@RestController
public class RestController1 {

	// 여기서 @ResponseBody 만 이야기함. 
	
	//텍스트 반환 
	@GetMapping(value="getText",
	produces="text/plain; charset= utf-8")
	public String getText() {
		return "안녕";
	}
	//JAVA BEAN(DTO) 반환 
	@GetMapping(value ="getDto", 
			produces= {"application/json; charset= utf-8",
					"application/xml; charset= utf-8"})
	public PersonDTO getDto() {
		return new PersonDTO("Max",25);
	}
	
	//List 반환 여러사람 반환 
	@GetMapping(value="getListJSON",
				produces =MediaType.APPLICATION_JSON_VALUE)
	public List<PersonDTO> getListJSON(){
		List<PersonDTO> list = new ArrayList<PersonDTO>();
		for (int i =1; i<=10; i++ ) {
			list.add(new PersonDTO("user" + i, 20 + i)); 
		}
		return list; 
	}
	
	//List 반환 여러사람 반환 
		@GetMapping(value="getListXML",
					produces =MediaType.APPLICATION_XML_VALUE)
		public List<PersonDTO> getListXML(){
			List<PersonDTO> list = new ArrayList<PersonDTO>();
			for (int i =1; i<=10; i++ ) {
				list.add(new PersonDTO("user" + i, 20 + i)); 
			}
			return list; 
		}
	//Map 반환 
	@GetMapping(value="getMap",
				produces =MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("date", new Date(System.currentTimeMillis()));
		map.put("place", "Seoul Mapo");
		map.put("teacher", new PersonDTO("Kim", 35));
		map.put("student", new PersonDTO("Park", 18));
		return map; 
	}
	//responseEntity 반환 
	@GetMapping(value="getCheck")
	public ResponseEntity<PersonDTO> getCheck(String name, int age){
		PersonDTO pDTO = null; 
		if(age < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pDTO);
		}else {
			pDTO = new PersonDTO(); 
			pDTO.setName(name);
			pDTO.setAge(age);
			return ResponseEntity.status(HttpStatus.OK).body(pDTO); 
		}
	}
}


























