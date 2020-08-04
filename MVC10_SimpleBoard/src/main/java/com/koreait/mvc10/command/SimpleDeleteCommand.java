package com.koreait.mvc10.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.koreait.mvc10.dao.SimpleDAO;

public class SimpleDeleteCommand implements SimpleCommand {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bNo= Integer.parseInt(request.getParameter("bNo"));
		SimpleDAO.getInstance().simpleDelete(bNo);
	}
}
