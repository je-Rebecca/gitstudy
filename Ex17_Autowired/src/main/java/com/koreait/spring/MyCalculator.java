package com.koreait.spring;
import org.springframework.beans.factory.annotation.Autowired;
public class MyCalculator {
	@Autowired
	private Calculator calcul;

	public void alarm() {
		System.out.println("alarm");
	}	
	public void addition(int num1, int num2) {
		calcul.addition(num1, num2);
	}
	public void subtraction(int num1, int num2) {
		calcul.subtraction(num1, num2);
	}
	public void multiplication(int num1, int num2) {
		calcul.multiplication(num1, num2);
	}
	public void division(int num1, int num2) {
		calcul.division(num1, num2);
	}
}
