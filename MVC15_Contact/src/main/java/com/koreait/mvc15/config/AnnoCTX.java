package com.koreait.mvc15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.mvc15.command.ContactDeleteCommand;
import com.koreait.mvc15.command.ContactInsertCommand;
import com.koreait.mvc15.command.ContactListCommand;
import com.koreait.mvc15.command.ContactUpdateCommand;
import com.koreait.mvc15.command.ContactViewCommand;

@Configuration  //bean 만드는 클래스
public class AnnoCTX {
	@Bean 
	public ContactListCommand contactListCommand() {
		return new ContactListCommand();
	}
	
	@Bean
	public ContactViewCommand contactViewCommand() {
		return new ContactViewCommand(); 
	}
	
	@Bean
	public ContactInsertCommand contactInsertCommand() {
		return new ContactInsertCommand();
	}
	
	@Bean
	public ContactDeleteCommand contactDeleteCommand() {
		return new ContactDeleteCommand();
	}
	
	@Bean
	public ContactUpdateCommand contactUpdateCommand() {
		return new ContactUpdateCommand();
	}

}
