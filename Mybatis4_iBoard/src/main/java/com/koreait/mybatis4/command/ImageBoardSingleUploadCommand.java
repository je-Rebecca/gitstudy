package com.koreait.mybatis4.command;

import java.io.File;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis4.dao.ImageBoardDAO;

public class ImageBoardSingleUploadCommand implements ImageBoardCommand {

	@Override
	public void execute(SqlSession ss, Model model) {
		Map<String, Object>map = model.asMap();
		MultipartHttpServletRequest mr 
		= (MultipartHttpServletRequest)map.get("mr");
		String iWriter = mr.getParameter("iWriter");
		String iTitle = mr.getParameter("iTitle");
		String iContent = mr.getParameter("iContent");
		MultipartFile files = mr.getFile("files");
		
		String originFilename =files.getOriginalFilename(); 
		String extName 
		= originFilename.substring(originFilename.lastIndexOf(".")+1);
		
		String saveFilename = null;
		try {
			saveFilename = originFilename.substring(0,originFilename.lastIndexOf("."))
					+ "_" + System.currentTimeMillis() +"."+ extName;
			
			//업로드 
			String realPath = mr.getSession().getServletContext().getRealPath("/resources/storage");
			
			File directory = new File(realPath);
			if(!directory.exists()) {
				directory.mkdirs();  //리눅스명령 .mkdirs 하위 디렉토리 모두 만들기
			}
			//서버에 저장할 파일 만듬 
			File saveFile = new File(realPath, saveFilename); //(경로, 파일명) 
			
			files.transferTo(saveFile);
			
			//DB저장 
			ImageBoardDAO iDAO = ss.getMapper(ImageBoardDAO.class);
			iDAO.imageBoardInsert(iWriter, iTitle, iContent, saveFilename);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
