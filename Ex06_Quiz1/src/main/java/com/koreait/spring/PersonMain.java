package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	
public static void main(String[] args) {
	// 다음과 같은 출력을 생성한다.
	
	String resourceLocations = "classpath:appCTX.xml"; 
	AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
	
	Person person1 = ctx.getBean("person",Person.class);
	person1.personInfo();
	ctx.close();
	
}
}
