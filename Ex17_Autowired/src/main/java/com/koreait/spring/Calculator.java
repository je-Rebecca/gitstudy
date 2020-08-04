package com.koreait.spring;
public class Calculator {

	//Method 
	public void addition(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + result);
	}
	public void subtraction(int num1, int num2) {
		int result = num1 - num2;
		System.out.println(num1 + "-" + num2 + "=" + result);
	}
	public void multiplication(int num1, int num2) {
		int result = num1 * num2;
		System.out.println(num1 + "*" + num2 + "=" + result);
	}
	public void division(int num1, int num2) {
		int result = num1 / num2;
		System.out.println(num1 + "/" + num2 + "=" + result);
	}
}
