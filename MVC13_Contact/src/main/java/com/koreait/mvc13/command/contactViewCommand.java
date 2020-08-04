package com.koreait.mvc13.command;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.koreait.mvc13.dao.ContactDAO;
import com.koreait.mvc13.dto.ContatctDTO;
public class contactViewCommand implements ContactCommand {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		ContactDAO cDAO = new ContactDAO();
		ContatctDTO cDTO = cDAO.selectContactBycNo(cNo);
		
		model.addAttribute("cDTO", cDTO);
	}
}
