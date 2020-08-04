package com.koreait.spring;
public class Person {
	private String name; 
	private int age;
	private Car car;
	
	public Person() {}
	
	public Person(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}
	public void personInfo() {
		System.out.println(name +"'s age is " +age);
		car.carInfo();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	

}
