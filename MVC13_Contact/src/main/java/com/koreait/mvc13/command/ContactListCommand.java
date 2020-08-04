package com.koreait.mvc13.command;
import java.util.ArrayList;			import org.springframework.ui.Model;	import com.koreait.mvc13.dao.ContactDAO;
import com.koreait.mvc13.dto.ContatctDTO;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		ContactDAO cDAO = new ContactDAO();
		ArrayList<ContatctDTO> list = cDAO.selectContactList();
		model.addAttribute("list",list);
	}

}
