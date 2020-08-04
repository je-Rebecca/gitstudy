package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class GugudanMain {

public static void main(String[] args) {
	
String resourceLocations ="classpath:appCTX.xml"; 
AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);

Gugudan dan1 = ctx.getBean("dan",Gugudan.class); 
dan1.GugudanInfo();
		
	// 다음과 같은 출력을 생성한다.
	// 3 X 5 = 15
	// 3 X 6 = 18
	// 3 X 7 = 21
	// 4 X 5 = 20
	// 4 X 6 = 24
	// 4 X 7 = 28
	}

}
