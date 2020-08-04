package com.koreait.spring;
public class PersonHandler {
	private Person person; 
	public PersonHandler() {}
	public PersonHandler(Person person) {
		super();
		this.person = person;
	}
	public void personInfo() {
		System.out.println(person.getName() +" :" +person.getAge());
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
