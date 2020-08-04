package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class); 
	Person p1 = ctx.getBean("p1", Person.class);
	System.out.println("No.1 : " +p1.getName() + p1.getHobbies());
	Person p2 = ctx.getBean("p2", Person.class);	
	System.out.println("No.2 : " +p2.getName() + p2.getHobbies());
	}

}
