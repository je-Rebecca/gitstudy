package com.koreait.pro.command;
import java.io.File;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.pro.dao.ProductDAO;

public class ProductInsertCommand implements ProCommand {
	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest request = (MultipartHttpServletRequest)map.get("request");
		
		int s_No = Integer.parseInt(request.getParameter("s_No"));
		String p_Name = request.getParameter("p_Name");
		String p_Cartegory = request.getParameter("p_Cartegory");
		String p_Content = request.getParameter("p_Content");
		int p_Price = Integer.parseInt(request.getParameter("p_Price"));
		
		MultipartFile p_Img_Path = request.getFile("p_Img_Path");
		
		// 업로드 된 원래 파일명
		String originFilename = p_Img_Path.getOriginalFilename();
		String extName = originFilename.substring(originFilename.lastIndexOf(".") + 1);
		
		// 저장할 파일 이름 만들기 / 업로드 / 파일이름 DB 에 저장
		String saveFilename = null;
		try {	// 1) 저장할 파일 이름 만들기
			saveFilename = originFilename.substring(0, originFilename.lastIndexOf(".")) +
						   "_" +  System.currentTimeMillis() + "." + extName;
			// 2) 업로드
			// 2-1) 파일이 저장될 서버 내 경로(/resources/storage)를 알아낸다.
			String realPath = request.getSession().getServletContext().getRealPath("/resources/storage");
			
			// 2-2) (/resources/storage) 경로가 존재하지 않으면 필요한 경로(디렉토리)를 만든다.
			// new File(경로) : 경로로 디렉토리만 사용되면 디렉토리로 인식한다.
			File directory = new File(realPath);
			if( !directory.exists() ) {
				directory.mkdir();  // mkdirs (하위 디렉토리를 모두 만든다.)
			}
			// 2-3) 서버에 저장할 파일을 만든다.
			File saveFile = new File(realPath, saveFilename);  // (경로, 파일명)
			// 2-4) 업로드한다.
			p_Img_Path.transferTo(saveFile);
			
			// 3) DB 에 저장  iWriter, iTitle, iContent, saveFilename		
			ProductDAO pDAO = sqlSession.getMapper(ProductDAO.class);
			pDAO.productInsert(s_No, p_Name, p_Cartegory, p_Content, p_Price, saveFilename);
		} catch (Exception e) {	e.printStackTrace();}
		
	}

}
