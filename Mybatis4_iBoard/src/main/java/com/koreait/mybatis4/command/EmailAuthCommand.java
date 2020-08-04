package com.koreait.mybatis4.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;

public class EmailAuthCommand implements ImageBoardCommand {

	@Override
	public void execute(SqlSession ss, Model model) {
		try {
			
			long authkey = 0;
			
			Map<String, Object>map = model.asMap();
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			JavaMailSender mailSender = (JavaMailSender)map.get("mailSender");
			
			SimpleMailMessage message= new SimpleMailMessage();
			
			message.setFrom("ccg@aol.com"); //보내는 사람의 메일주소
			message.setTo(request.getParameter("email"));//받는 사람 메일주소
			message.setSubject("Confirm email"); //제목
			authkey =((long)Math.random() *1000000000)+123456789;
			message.setText("please type these numbers to verify your email");
			message.setText("인증번호" +authkey); //내용
			
			mailSender.send(message);
			
			model.addAttribute("authkey", authkey);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
