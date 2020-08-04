package com.koreait.mvc09.calculator;

public class Calculator {
	private int a; 
	private int b;
	private int result;
	public Calculator() {}
	public Calculator(int a, int b, int result) {
		super();
		this.a = a;
		this.b = b;
		this.result = result;
	}
	public void addition () {
		 int result= a+b;
		 System.out.println(a +" + "+ b + "=" + result );
	}
	public void substract () {
		 int result= a-b;
		 System.out.println(a +" - "+ b + "=" + result );
	}
	public void multiple () {
		  int result= a*b;
		  System.out.println(a +" / "+ b + "=" + result );
	}
	public void divide() {
		  int result= a/b;
		  System.out.println(a +" * "+ b + "=" + result );
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
