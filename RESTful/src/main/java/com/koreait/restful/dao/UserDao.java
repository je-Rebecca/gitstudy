package com.koreait.restful.dao;
import java.util.List;

import com.koreait.restful.dto.UserDto;

public interface UserDao {
	public List<UserDto> selectUserList();
	
	public UserDto selectByUserId(String userId);
	
	public int insertUser(UserDto userdto);
	
	public int updateUser(UserDto userdto); 
	
	public int deleteUser(String userId); 
}
