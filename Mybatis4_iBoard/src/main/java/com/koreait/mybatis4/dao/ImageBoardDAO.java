package com.koreait.mybatis4.dao;

import java.util.ArrayList;

import com.koreait.mybatis4.dto.ImageBoardDTO;

public interface ImageBoardDAO {
	public void imageBoardInsert(String iWriter, String iTitle,String iContent,String saveFilename);
	
	public ArrayList<ImageBoardDTO> selectimageBoardlist();
}
