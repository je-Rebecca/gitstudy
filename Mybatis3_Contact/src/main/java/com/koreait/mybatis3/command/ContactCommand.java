package com.koreait.mybatis3.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ContactCommand {
	public void execute(SqlSession ss,Model model);
}
