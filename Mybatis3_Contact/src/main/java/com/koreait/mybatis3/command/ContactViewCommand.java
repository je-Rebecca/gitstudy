package com.koreait.mybatis3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.ContactDAO;
import com.koreait.mybatis3.dto.ContactDTO;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(SqlSession ss, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		ContactDAO cDAO = ss.getMapper(ContactDAO.class);
		ContactDTO cDTO = cDAO.selectContactBycNo(cNo);
		
		model.addAttribute("cDTO", cDTO);
	}

}
