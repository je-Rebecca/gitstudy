package com.koreait.spring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AnnoCTX {
	@Bean
	public Song mySong() {
		Song song = new Song();
		song.setTitle("좋은 날"); 
		song.setGenre("Balad");
		song.setPlayTime(3.38);
		return song;
	}
	@Bean
	public Singer she() {
		Singer sg = new Singer();
		sg.setName("IU");
		sg.setSong(mySong());
		return sg;
	}
}
