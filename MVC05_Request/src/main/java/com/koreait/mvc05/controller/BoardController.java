package com.koreait.mvc05.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc05.dto.BoardDTO;
@Controller
@RequestMapping("board")
public class BoardController {
	@RequestMapping("v05")
	public String goView05(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		int hit = Integer.parseInt(request.getParameter("hit")) ; 
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("hit", hit);
		return "board/view05";
	}
	@RequestMapping("v06")
	public String goView06(@RequestParam("title") String title, 
							@RequestParam("content") String content,
							@RequestParam("hit") int hit, Model mode) {
		mode.addAttribute("title",title); 
		mode.addAttribute("content",content); 
		mode.addAttribute("hit",hit); 
		return "board/view06";
	}
	@RequestMapping("v07")
	public String goView07(@RequestParam("title") String title, 
							@RequestParam("content") String content,
							@RequestParam("hit") int hit, Model mode) {
		BoardDTO bDTO = new BoardDTO();
		bDTO.setTitle(title);
		bDTO.setContent(content);
		bDTO.setHit(hit);
		mode.addAttribute("bDTO", bDTO);
		return "board/view07";
	}
	@RequestMapping("v08")
	public String goView08(BoardDTO bDTO, Model model) {
		model.addAttribute("bDTO", bDTO);
		return "board/view08";
	}
	@RequestMapping("v09")
	public String goView09(@ModelAttribute("bDTO") BoardDTO bDTO) {
		return "board/view09";
	}
}

