package com.koreait.mybatis2.dao;

import java.util.ArrayList;

import com.koreait.mybatis2.dto.SimpleDTO;

public interface SimpleDAO {
//전체목록 
	public ArrayList<SimpleDTO> selectSimpleList();
	
	public SimpleDTO selectBybNo(int bNo);
	//수정
	public void updateSimple(String bTitle, String bContent, int bNo);
	public void deleteSimple(int bNo);
	//삽입
	public int insertSimple(String bWriter,String bTitle, String bContent);
}
