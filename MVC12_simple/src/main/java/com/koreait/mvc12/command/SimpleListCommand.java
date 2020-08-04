package com.koreait.mvc12.command;
import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreait.mvc12.dao.SimpleDAO;
import com.koreait.mvc12.dto.SimpleDTO;

public class SimpleListCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		ArrayList<SimpleDTO> list = SimpleDAO.getInstance().selectSimpleList();
		model.addAttribute("list",list);
	}

}
