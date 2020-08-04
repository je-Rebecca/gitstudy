package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComputerMain {

	public static void main(String[] args) {
		String resourceLocations ="classpath:AppCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);	
		Computer com = ctx.getBean("com", Computer.class);
		com.playGame();
		com.developApp();
		com.volumnUp();
		com.volumnDown();
		ctx.close();
	}
}
