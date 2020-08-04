package com.koreait.spring;

public class CalculatorMain {

public static void main(String[] args) {
	//default cal 쓰려면 생성자 + setter 필요
	MyCalculator myCal1 = new MyCalculator();
	myCal1.setNum1(10);
	myCal1.setNum2(3);
	myCal1.setCalculator(new Calculator());//주입
	myCal1.addtion();
	myCal1.division();
	myCal1.multiplication();
	myCal1.division();
	
	//필드 생성자
	MyCalculator myCal2 
	= new MyCalculator(100,30, new Calculator());
	myCal2.addtion();
	myCal2.subtraction();
	myCal2.multiplication();
	myCal2.division();

	}
}
