package com.koreait.finalproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.finalproject.dao.BoardDao;

public class deleteCommand implements BoardCommand {
	@Override
	public void execute(SqlSession sqlsession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		int bIdx= Integer.parseInt(request.getParameter("bIdx"));
		BoardDao bDao = sqlsession.getMapper(BoardDao.class);
		bDao.deleteSimple(bIdx);
	}
}
