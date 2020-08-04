package com.koreait.spring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {
	//Method 
	@Bean
	public Person p1() {
		Person person = new Person(); 
		person.setName("Paul");
		person.setAge(25);
		return person; 
	}
	@Bean(name ="p2")
	public Person abc() {
		Person person = new Person();
		person.setName("Ben");
		person.setAge(19);
		return person; 
	}//Bean id ="pInfo"  class =PersonHandler 
	@Bean
	public PersonHandler pInfo1(){
		PersonHandler local = new PersonHandler();
		local.setPerson(new Person("Alice", 27));
		return local;
	}//Bean id ="pInfo2"  class =PersonHandler 
	@Bean
	public PersonHandler pInfo2(){
		PersonHandler local = new PersonHandler();
		local.setPerson(p1());
		return local;
	}//Bean id ="pInfo3"  class =PersonHandler 
	@Bean
	public PersonHandler pInfo3(){
		PersonHandler local = new PersonHandler();
		local.setPerson(abc());
		return local;
	}
	
}
