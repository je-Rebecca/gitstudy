package com.koreait.finalproject.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BoardCommand {
	
	public void execute(SqlSession sqlsession, Model model);

}
