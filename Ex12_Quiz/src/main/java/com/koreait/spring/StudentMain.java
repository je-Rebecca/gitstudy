package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
		Studnet student = ctx.getBean("s1", Studnet.class);
		
		student.studentInfo();
		ctx.close();
		
	}

}
