package com.koreait.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AnnoCTX {
	@Bean
	public Studnet s1() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(90);
		list.add(80);
		list.add(70);

		HashSet<String> set = new HashSet<String>();
		set.add("벽화그리기");
		set.add("쓰레기 줍기");
		set.add("환경미화");
		
		HashMap<String, String>map = new HashMap<String, String>();
		map.put("address", "서울시 마포구");
		map.put("phone", "010-000-0000");
		
		Studnet st = new Studnet();
		st.setName("Tom");
		st.setScores(list);
		st.setVolunteers(set);
		st.setHomeInfo(map);
		return st;
		
	}
}
