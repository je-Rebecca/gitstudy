package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {

	public static void main(String[] args) {
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		MyCalculator myCalculator1 = ctx.getBean("myCalc", MyCalculator.class);
		myCalculator1.addtion();
		myCalculator1.subtraction();
		myCalculator1.multiplication();
		myCalculator1.division();
		
		
		MyCalculator myCalculator2 = ctx.getBean("myCalc2", MyCalculator.class);
		myCalculator2.addtion();
		myCalculator2.subtraction();
		myCalculator2.multiplication();
		myCalculator2.division();
		
		ctx.close();
	}

}
