package com.koreait.restful.controller;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.restful.command.UserCommand;
import com.koreait.restful.command.UserDeleteCommand;
import com.koreait.restful.command.UserInsertCommand;
import com.koreait.restful.command.UserListCommand;
import com.koreait.restful.command.UserViewCommand;
import com.koreait.restful.command.userUpdateCommand;
import com.koreait.restful.dto.UserDto;

@Controller
public class UserController {


	@Autowired
	private SqlSession ss; 
	private UserCommand userCommand; 
	
	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	
	@RequestMapping(value="users", 
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> selectUserList(Model model){
		userCommand = new UserListCommand();
		Map<String, Object> map = userCommand.execute(ss, model);
		return map;
	}
	@RequestMapping(value="users/{userId}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> 
		selectByUserId(@PathVariable("userId") String userId,Model model){
		
		model.addAttribute("userId", userId);
		userCommand = new UserViewCommand();
		return userCommand.execute(ss, model);
		
	}
	@RequestMapping(value ="users",
					method= RequestMethod.POST,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> insertUser(@RequestBody UserDto userDto,
											Model model){
		if(userDto != null) {
			model.addAttribute("userDto", userDto);
			userCommand = new UserInsertCommand();
		}
		return userCommand.execute(ss, model);
	}
	@RequestMapping(value ="users",
			method= RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> updateUser(@RequestBody UserDto userDto, Model model){
		if(userDto != null) {
			model.addAttribute("userDto", userDto);
			userCommand = new userUpdateCommand();
		}
		return userCommand.execute(ss, model);
	}
	
	@RequestMapping(value ="users/{userId}",
			method= RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable("userId") String userId,
											Model model){
		model.addAttribute("userId", userId);
		userCommand = new UserDeleteCommand();
		return userCommand.execute(ss, model);
	}
	}
