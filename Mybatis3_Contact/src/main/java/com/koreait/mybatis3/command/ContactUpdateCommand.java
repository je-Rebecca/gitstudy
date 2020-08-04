package com.koreait.mybatis3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.ContactDAO;

public class ContactUpdateCommand implements ContactCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String cName = request.getParameter("cName");
		String cPhone = request.getParameter("cPhone");
		String cAddress = request.getParameter("cAddress");
		String cEmail = request.getParameter("cEmail");
		String cNote = request.getParameter("cNote");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		ContactDAO cDAO = sqlSession.getMapper(ContactDAO.class);
		cDAO.contactUpdate(cName, cPhone, cAddress, cEmail, cNote, cNo);
		
		model.addAttribute("cNo", cNo);
		
	}

}
