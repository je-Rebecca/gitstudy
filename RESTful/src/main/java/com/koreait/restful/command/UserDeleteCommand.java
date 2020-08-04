package com.koreait.restful.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.restful.dao.UserDao;
import com.koreait.restful.dto.UserDto;

public class UserDeleteCommand implements UserCommand {

	@Override
	public Map<String, Object> execute(SqlSession ss, Model model) {
		Map<String, Object> map = model.asMap();
		String userId = (String) map.get("userId");
		UserDao uDao = ss.getMapper(UserDao.class);
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("reuslt", uDao.deleteUser(userId));
		
		return resultMap;
	}

}
