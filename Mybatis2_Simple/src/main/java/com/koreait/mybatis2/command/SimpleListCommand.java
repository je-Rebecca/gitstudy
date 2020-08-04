package com.koreait.mybatis2.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.dao.SimpleDAO;
import com.koreait.mybatis2.dto.SimpleDTO;

public class SimpleListCommand implements SimpleCommand {

	@Override
	public void excute(SqlSession ss, Model model) {
		SimpleDAO sDAO = ss.getMapper(SimpleDAO.class);
	ArrayList<SimpleDTO>list = sDAO.selectSimpleList();
	model.addAttribute("list", list);
	model.addAttribute("totalCount", list.size());
	}

}
