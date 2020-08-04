package com.koreait.restful.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface UserCommand {
	public Map<String, Object> execute(SqlSession ss, Model model); 
}
