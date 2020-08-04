package com.koreait.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor  //필드를 이용한 생성자를 만들어 주세요. 
@NoArgsConstructor   //default 생성자를 만들어 주세요 
public class PersonDTO {
	//lombock 을 사용할 땐 "필드" 만 추가한다. 
	private String name; 
	private int age;
	
	
}
