package com.koreait.mybatis4.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

public class ImageBoardDownloadCommand implements ImageBoardCommand {

	@Override
	public void execute(SqlSession ss, Model model) {
	Map<String, Object> map = model.asMap();
	HttpServletRequest request =(HttpServletRequest) map.get("request");
	HttpServletResponse response =(HttpServletResponse) map.get("response");

	String realPath = request.getSession().getServletContext().getRealPath("/resources/storage");
	
	String iFilename = request.getParameter("iFilename");
	
	String extName = iFilename.substring(iFilename.lastIndexOf(".") +1);
	String downloadFilename =iFilename.substring(0,iFilename.lastIndexOf("_"))
				+ "." + extName;
		
		File file = new File(realPath, iFilename); //경로, 파일명 
		
		BufferedInputStream bis = null; 
		BufferedOutputStream bos = null; 
		
try {
	response.setHeader("Content-Type", "application/x-msdownload");
	response.setHeader("Content-Disposition", "attachment; filename="
	+ new String(URLEncoder.encode(downloadFilename, "utf-8")).replaceAll("\\+", " "));
	response.setHeader("Content-Length", file.length()+"");	
	
	bis = new BufferedInputStream(new FileInputStream(file));
	bos = new BufferedOutputStream(response.getOutputStream());
	
	FileCopyUtils.copy(bis, bos);
	bos.flush();	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(bos != null) {bos.close();}
			if(bis != null) {bis.close();}
		}catch (Exception e) {e.printStackTrace();	}
	}
}
}
