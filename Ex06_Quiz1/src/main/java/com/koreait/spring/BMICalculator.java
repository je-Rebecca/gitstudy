package com.koreait.spring;
public class BMICalculator {
	// Field  저체중(bmi : ~19) 
		private double normal; // 정상(bmi : 20~25)
		private double over; // 과체중(bmi : 26~30)
		private double obesity; // 비만(bmi : 31~)
		
	public BMICalculator() {}
	public void bmiInfo(double weight, double height) {
		double h = height *0.01; // cm->m 
		double bmi = weight / (h *h); 
		String state = null; 
		if(bmi >= obesity) {
			state ="비만";
		}else if(bmi>= over) {
			state ="과체중";
		}else if(bmi >= normal) {
			state="정상";
		}else {
			state ="저체중";
		}
		System.out.println("체질량지수 :" +bmi + "(" +state +")");
	}
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	
	
	
	
}
