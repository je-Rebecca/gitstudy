package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class PersonMain {
	public static void main(String[] args) {
		String resourceLocations1 = "classpath:appCTX1.xml";
		String resourceLocations2 = "classpath:appCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations1,resourceLocations2);
		Person person =ctx.getBean("p", Person.class);
		person.personInfo();
		ctx.close();
	}

}
