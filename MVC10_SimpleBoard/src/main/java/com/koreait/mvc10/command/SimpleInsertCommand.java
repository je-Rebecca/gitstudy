package com.koreait.mvc10.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc10.dao.SimpleDAO;

public class SimpleInsertCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		
		// model 에 저장된 request 를 꺼내자.
		
		Map<String, Object> map = model.asMap();  // model 을 Map 구조로 바꾼다.
		HttpServletRequest request = (HttpServletRequest) map.get("req");
		
		String bWriter = request.getParameter("bWriter");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		SimpleDAO.getInstance().simpleInsert(bWriter, bTitle, bContent);
		
	}

}






