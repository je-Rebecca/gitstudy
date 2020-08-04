package com.koreait.mvc12.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.mvc12.dao.SimpleDAO;
import com.koreait.mvc12.dto.SimpleDTO;

public class SimpleInsertCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map  = model.asMap();
		SimpleDTO sDTO =(SimpleDTO) map.get("sDTO");
		
		SimpleDAO.getInstance().insert(sDTO);

	}

}
