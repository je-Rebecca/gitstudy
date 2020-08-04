package com.koreait.mybatis2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.dao.SimpleDAO;

public class SimpleInsertCommand implements SimpleCommand {

	@Override
	public void excute(SqlSession ss, Model model) {
	Map<String, Object> map = model.asMap();
	RedirectAttributes rttr = (RedirectAttributes)map.get("rttr");
	HttpServletRequest request =(HttpServletRequest)map.get("request");
	
	String bWriter = request.getParameter("bWriter");
	String bTitle = request.getParameter("bTitle");
	String bContent = request.getParameter("bContent");
	
	SimpleDAO sDAO = ss.getMapper(SimpleDAO.class);
	rttr.addFlashAttribute("insertResult",sDAO.insertSimple(bWriter, bTitle, bContent));
	
	rttr.addFlashAttribute("beInserted",true);
	}
}
