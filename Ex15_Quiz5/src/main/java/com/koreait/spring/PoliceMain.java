package com.koreait.spring;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class PoliceMain {
	public static void main(String[] args) {
		
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		Police police = ctx.getBean("p1", Police.class);
		System.out.println(police.getName());
		System.out.println("부서명 :" +police.getDeptInfo().get("depName"));
		System.out.println("위치 :" +police.getDeptInfo().get("depLocation"));
		System.out.println("총 :" +police.getPistol().getModel());
		System.out.println("총알수 :" +police.getPistol().getBullet() +"발");
		ctx.close();
	}
}
