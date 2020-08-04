package com.koreait.restful.command;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.restful.dao.UserDao;
import com.koreait.restful.dto.UserDto;

public class UserListCommand implements UserCommand {
	@Override
	public Map<String, Object> execute(SqlSession ss, Model model) {
		UserDao uDao = ss.getMapper(UserDao.class);
		List<UserDto> userList = uDao.selectUserList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userList);
		map.put("result", true);
		return map;
	}
}
