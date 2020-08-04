package com.koreait.mybatis4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis4.command.EmailAuthCommand;
import com.koreait.mybatis4.command.ImageBoardCommand;
import com.koreait.mybatis4.command.ImageBoardDownloadCommand;
import com.koreait.mybatis4.command.ImageBoardListCommand;
import com.koreait.mybatis4.command.ImageBoardMultiUploadCommand;

@Controller
public class ImageBoardController {
	
	@Autowired
	private SqlSession ss; 
	private ImageBoardCommand IBC;
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	@RequestMapping("uploadPage")
	public String goUploadPage() {
		return "uploadPage";
	}
	@RequestMapping("imageBoardListPage")
	public String imageBoardListPage(Model model) {
		IBC = new ImageBoardListCommand();
		IBC.execute(ss, model);
		return "imageBoardListPage"; 
	}
	@RequestMapping(value ="multiUpload", method=RequestMethod.POST)
	public String multiUpload(MultipartHttpServletRequest mr, Model model) {
		model.addAttribute("mr", mr);
		IBC = new ImageBoardMultiUploadCommand();
		IBC.execute(ss, model);
		return "redirect:imageBoardListPage";
	}
	@RequestMapping("download")
	public void download(HttpServletRequest request,HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		IBC = new ImageBoardDownloadCommand();
		IBC.execute(ss, model);
	}
	
	@Autowired
	private JavaMailSender mailSender; 
	
	@RequestMapping("emailAuth")
	public String emailAuth(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("mailSender", mailSender);
		IBC = new EmailAuthCommand();
		IBC.execute(ss, model);
		return "emailAutoConfirm";//이메일 인증코드를 emailAutoConfirm.jsp로 보내준다. 
	}
}
