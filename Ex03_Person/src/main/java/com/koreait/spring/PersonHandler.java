package com.koreait.spring;
public class PersonHandler {	
	private Person person;   	//필드
	public PersonHandler() {}	//생성자- 디폴트
	public PersonHandler(Person person) { //필드이용 생성자
		super();
		this.person = person;
	}	//메소드 
	public void personInfo() {
		System.out.println("名字 " + person.getName());
		System.out.println("年龄" + person.getAge());
		System.out.println("性别" + person.getGender());
		System.out.println("电话" + person.getPhone());
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
