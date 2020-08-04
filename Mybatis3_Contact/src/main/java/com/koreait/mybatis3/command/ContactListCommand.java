package com.koreait.mybatis3.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.ContactDAO;
import com.koreait.mybatis3.dto.ContactDTO;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(SqlSession ss, Model model) {
		ContactDAO cDAO = ss.getMapper(ContactDAO.class);
		ArrayList<ContactDTO> list = cDAO.selectContactList();
		model.addAttribute("list", list);

	}

}
