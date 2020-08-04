package com.koreait.finalproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.finalproject.dao.BoardDao;

public class BoardInsertCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlsession, Model model) {
		Map<String, Object> map = model.asMap();
		RedirectAttributes rttr = (RedirectAttributes)map.get("rttr");
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		String bWriter = request.getParameter("bWriter");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDao bDao = sqlsession.getMapper(BoardDao.class);
		rttr.addFlashAttribute("insertResult", bDao.insertBoard(bWriter, bTitle, bContent));
		
		rttr.addFlashAttribute("beInserted",true);

	}

}
