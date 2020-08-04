package com.koreait.mvc11.command;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.koreait.mvc11.dao.SimpleDAO;
import com.koreait.mvc11.dto.SimpleDTO;

public class SimpleViewCommand implements SimpleCommand {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bNo= Integer.parseInt(request.getParameter("bNo"));
		SimpleDTO sDTO = SimpleDAO.getInstance().selectBybNo(bNo);
		model.addAttribute("sDTO", sDTO);
	}

}
