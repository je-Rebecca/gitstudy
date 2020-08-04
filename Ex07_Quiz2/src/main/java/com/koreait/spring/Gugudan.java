package com.koreait.spring;
public class Gugudan {
	private int startDan;
	private int endDan;
	private int startNum;
	private int endNum;
	private Calculator calculator;
	
	public Gugudan() {}
	public void GugudanInfo() {
		for(int dan = startDan; dan<= endDan; dan++) {
		for(int num = startNum; num <= endNum; num++) {
		System.out.println(dan + "x" + num +"=" + calculator.multiplication(dan, num));
				}
			}
		}
		
		/*public void GugudanInfo() {
			System.out.print("시작단" + startDan + "|");
			System.out.print("끝단" + endDan+ "|");
			System.out.print("시작번호" + startNum+ "|");
			System.out.println("끝번호" + endNum);
			calculatorInfo();
		}
		public void calculatorInfo() {
			calculator.calculatorInfo(startDan, endDan, startNum, endNum);
		}*/
		public int getStartDan() {
			return startDan;
		}
		public void setStartDan(int startDan) {
			this.startDan = startDan;
		}
		public int getEndDan() {
			return endDan;
		}
		public void setEndDan(int endDan) {
			this.endDan = endDan;
		}
		public int getStartNum() {
			return startNum;
		}
		public void setStartNum(int startNum) {
			this.startNum = startNum;
		}
		public int getEndNum() {
			return endNum;
		}
		public void setEndNum(int endNum) {
			this.endNum = endNum;
		}
		public Calculator getCalculator() {
			return calculator;
		}
		public void setCalculator(Calculator calculator) {
			this.calculator = calculator;
		}
}
