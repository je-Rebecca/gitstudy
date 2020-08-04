package com.koreait.finalproject.dao;

import java.util.ArrayList;

import com.koreait.finalproject.dto.BoardDTO;

public interface BoardDao {
	public ArrayList<BoardDao> selectList();
	
	public BoardDTO selectByIdx(int bIdx);
	
	public int insertBoard(String bWriter, String bTitle, String bContent);
	
	public void updateBoard(String bTitle, String bContent, int bIdx);
	
	public void deleteSimple(int bIdx);
}
