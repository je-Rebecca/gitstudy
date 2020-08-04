package com.koreait.mvc11.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc11.dao.SimpleDAO;
import com.koreait.mvc11.dto.SimpleDTO;

public class SimpleUpdateCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map  = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SimpleDTO sDTO = new SimpleDTO();
		sDTO.setbNo(Integer.parseInt(request.getParameter("bNo")));
		sDTO.setbTitle(request.getParameter("bTitle"));
		sDTO.setbContent(request.getParameter("bContent"));
		SimpleDAO.getInstance().updateSimple(sDTO);
		//model.addAttribute("sDTO", SimpleDAO.getInstance().selectBybNo(Integer.parseInt(request.getParameter("bNo"))));
		//수정후, view로 이동할때 bNo를 같이 보내기 
		model.addAttribute("bNo", sDTO.getbNo());
	}
}
