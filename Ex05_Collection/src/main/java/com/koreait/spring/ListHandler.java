package com.koreait.spring;
import java.util.List;
public class ListHandler {
	private List<String> list;
	
	//default생성자 작업
	public ListHandler() {	}
	
	//method 
	public void listInfo() {
		for(int i = 0, len = list.size(); i<len; i++) {
			System.out.println(i +": " +list.get(i));
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	
}
