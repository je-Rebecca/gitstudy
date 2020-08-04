package com.koreait.spring;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
@ImportResource("classpath:appCTX.xml")
@Configuration
public class AnnoCTX {
	@Bean
	public Person p2() {
		ArrayList<String>list = new ArrayList<String>();
		list.add("Movie");
		list.add("Cook");
		list.add("Shopping");
		Person person = new Person();
		person.setName("William");
		person.setHobbies(list);
		return person;
	}
}
