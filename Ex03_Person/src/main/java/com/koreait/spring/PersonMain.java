package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		
		String resourceLocation ="classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		//getBean("bean 아이디 " , bean 태그 클래스명 )
		PersonHandler handler1 = ctx.getBean("handler1", PersonHandler.class);
		PersonHandler handler2 = ctx.getBean("handler2", PersonHandler.class); 

		handler1.personInfo();
		handler2.personInfo();
		
		ctx.close();
		
	/*	Person p1 = new Person(); //default생성 
		//setter를 통한 주입
		p1.setName("Janney");
		p1.setAge(20);
		p1.setGender('F');
		p1.setPhone("010-222-2222");
		// 필드 이용한 생성자로 주입 
		Person p2 = new Person("Tom",30,'M',"010-333-3333");
		
		//디폴트 생성 
		PersonHandler handler1 = new PersonHandler();
		//setter로 주입 
		handler1.setPerson(p1);
		//필드를 이용한 생성자로 주입 
		PersonHandler handler2 = new PersonHandler(p2);
		*/
	}
}
