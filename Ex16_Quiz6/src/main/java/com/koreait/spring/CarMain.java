package com.koreait.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class CarMain {
	public static void main(String[] args) {
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	Car car = ctx.getBean("c1", Car.class);
	System.out.println("모델 : " + car.getModel());
	System.out.println("연료 : " + car.getEngine().getFuelType());
	System.out.println("배기량 : " + car.getEngine().getCc());
	System.out.println("마력 : " + car.getEngine().getHp());
	System.out.println("연비 : " + car.getEngine().getFuelEfficiency());
	ctx.close();
	}

}
