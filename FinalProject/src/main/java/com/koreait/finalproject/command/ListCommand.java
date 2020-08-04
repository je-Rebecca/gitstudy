package com.koreait.finalproject.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.finalproject.dao.BoardDao;

public class ListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		BoardDao bDao = sqlsession.getMapper(BoardDao.class);
		ArrayList<BoardDao> list =bDao.selectList();
		model.addAttribute("list",list);
	}

}
