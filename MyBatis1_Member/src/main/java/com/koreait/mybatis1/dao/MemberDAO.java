package com.koreait.mybatis1.dao;

import java.util.ArrayList;

import com.koreait.mybatis1.dto.MemberDTO;

public interface MemberDAO {
	// 1. 전체 목록 가져오기
	public ArrayList<MemberDTO> selectMemberList();
	
	//삽입하기 
	public void insertMember(String mId, String mName); 
	
	//정보보기 
	public MemberDTO selectBymNo(int mNo);
	
	//수정
	public void updateMember(String mName, int mNo);
	//삭제
	public void deleteMember(int mNo);
	
	
}








