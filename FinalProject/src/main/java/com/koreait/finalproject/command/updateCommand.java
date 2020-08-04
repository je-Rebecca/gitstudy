package com.koreait.finalproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.finalproject.dao.BoardDao;

public class updateCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bIdx = Integer.parseInt(request.getParameter("bIdx"));
		
		BoardDao bDao = sqlsession.getMapper(BoardDao.class);
		bDao.updateBoard(bTitle, bContent, bIdx);
		model.addAttribute("bIdx",bIdx);
	}

}
