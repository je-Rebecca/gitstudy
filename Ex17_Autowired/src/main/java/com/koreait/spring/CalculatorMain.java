package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {

	public static void main(String[] args) {
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		MyCalculator myCal = ctx.getBean("myCal", MyCalculator.class);
		myCal.addition(1, 1);
		myCal.division(4, 2);
		myCal.alarm();
		ctx.close();
	}
}
