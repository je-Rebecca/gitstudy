package com.koreait.mybatis2.command;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.dao.SimpleDAO;

public class SimpleViewCommand implements SimpleCommand {

	@Override
	public void excute(SqlSession ss, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		SimpleDAO sDAO = ss.getMapper(SimpleDAO.class);
		model.addAttribute("sDTO", sDAO.selectBybNo(bNo));
	}

}
