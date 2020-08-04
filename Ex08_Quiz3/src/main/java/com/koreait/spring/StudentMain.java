package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		Student s1 = ctx.getBean("student",Student.class);
		s1.studentInfo();
		
		
		ctx.close();
		
		
		// 다음과 같은 출력을 생성한다.

		/*name: david
		home's address: seoul
		home's phone: 02-555-5555
		scoreList: [50, 60, 70, 80, 90]
		average: 70.0
		grade: C*/
	}

}
