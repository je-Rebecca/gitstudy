package com.koreait.mybatis3.dao;

import java.util.ArrayList;

import com.koreait.mybatis3.dto.ContactDTO;

public interface ContactDAO {
	
	public ArrayList<ContactDTO> selectContactList();
	public ContactDTO selectContactBycNo(int cNo);
	public void contactInsert(String cName, String cPhone, String cAddress, String cEmail, String cNote);
	public void contactDelete(int cNo);
	public void contactUpdate(String cName, String cPhone, String cAddress, String cEmail, String cNote, int cNo);
}
