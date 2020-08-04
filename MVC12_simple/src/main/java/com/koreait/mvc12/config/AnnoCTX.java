package com.koreait.mvc12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.mvc12.command.SimpleDeleteCommand;
import com.koreait.mvc12.command.SimpleInsertCommand;
import com.koreait.mvc12.command.SimpleListCommand;
import com.koreait.mvc12.command.SimpleUpdateCommand;
import com.koreait.mvc12.command.SimpleViewCommand;

@Configuration
public class AnnoCTX {
//ctx.getBean("simpleListCommand",SimpleListCommand.class)
	@Bean   
	public SimpleListCommand simpleListCommand() {
		return new SimpleListCommand();
	}
	@Bean
	public SimpleViewCommand simpleViewCommand() {
		return new SimpleViewCommand();
	}
	@Bean
	public SimpleInsertCommand simpleInsertCommand() {
		return new SimpleInsertCommand();
	}
	@Bean
	public SimpleUpdateCommand SimpleUpdateCommand() {
		return new SimpleUpdateCommand();
	}
	@Bean
	public SimpleDeleteCommand simpleDeleteCommand() {
		return new SimpleDeleteCommand();
	}
}
