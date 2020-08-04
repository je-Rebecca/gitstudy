package com.koreait.spring;
import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	@Autowired
	private Speaker speaker;
	
	public void playGame() {
		System.out.println("play game");
	}
	public void developApp() {
		System.out.println("coding");
	}
	public void volumnUp() {
		speaker.volumeUp();
	}
	public void volumnDown() {
		speaker.volumeDown();
	}
}
