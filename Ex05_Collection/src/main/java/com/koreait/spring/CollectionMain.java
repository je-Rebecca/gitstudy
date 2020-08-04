package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
	
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		ListHandler listhandler = ctx.getBean("handler1", ListHandler.class);
		listhandler.listInfo();
		
		SetHandler sethandler = ctx.getBean("handler2",SetHandler.class);
		sethandler.setInfo();
		
		MapHandler maphandler = ctx.getBean("handler3", MapHandler.class);
		maphandler.MapInfo();
		ctx.close();
		
	}

}
