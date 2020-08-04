package com.koreait.restful.dto;
//lombok 라이브러리 사용 
//@Data:  @Getter, @Setter  @NoArgsConstructor 디폴트 생성자 
//@AllArgsConstuctor:필드 이용한 생성자

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String userId;
	private String userName;
	private String gender;
	private String address;
}
