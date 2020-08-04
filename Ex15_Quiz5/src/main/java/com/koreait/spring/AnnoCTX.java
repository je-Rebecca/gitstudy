package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AnnoCTX {
	@Bean
	public Gun g1() {
		Gun gun = new Gun();
		gun.setModel("베테라");
		gun.setBullet(6);
		return gun;
//Gun gun = new Gun("베레타",6); 가능 생성자 만들어서
	}
}
