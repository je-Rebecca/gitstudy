package com.koreait.mvc11.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.koreait.mvc11.dto.SimpleDTO;
public class SimpleDAO {
	private DataSource ds;
	private SimpleDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  
		}catch(Exception e) {e.printStackTrace();}
	}	// Singleton Pattern
	private static SimpleDAO sDao = new SimpleDAO();
	public static SimpleDAO getInstance() {
		return sDao;
	}
	private Connection conn;	
	private PreparedStatement ps; 
	private ResultSet rs;
	private String sql;
	
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}//close 처리는 메소드 마다 무조건 해야함. 
	} 	
	// 실제 DB 처리하는 메소드  
	//1 selectSimpleList() 
	public ArrayList<SimpleDTO> selectSimpleList() {
		ArrayList<SimpleDTO> list = new ArrayList<SimpleDTO>();
		try {
			conn = ds.getConnection();
			sql="SELECT BNO, BWRITER, BTITLE, BCONTENT, BDATE FROM SIMPLE ORDER BY BNO DESC";
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				int bNo = rs.getInt(1);
				String bWriter = rs.getString(2);
				String bTitle = rs.getString(3);
				String bContent = rs.getString(4);
				Date bDate = rs.getDate(5);
				SimpleDTO sDTO = new SimpleDTO(bNo, bWriter, bTitle, bContent, bDate);
				list.add(sDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return list;
	}
	//2. selectBybNo()
	public SimpleDTO selectBybNo(int bNo) {
		SimpleDTO sDTO = null;
		try {
			conn = ds.getConnection();
			sql= "SELECT BNO, BWRITER, BTITLE, BCONTENT, BDATE FROM SIMPLE WHERE BNO =?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,bNo);
			rs= ps.executeQuery();
			while(rs.next()) {
				String bWriter = rs.getString(2);
				String bTitle = rs.getString(3);
				String bContent = rs.getString(4);
				Date bDate = rs.getDate(5);
				sDTO = new SimpleDTO(bNo, bWriter, bTitle, bContent, bDate);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return sDTO;
	}
	//3. updateSimple()
	public void updateSimple(SimpleDTO sDTO) {
		try {
			conn = ds.getConnection();
			sql ="UPDATE SIMPLE SET BTITLE=?, BCONTENT=? WHERE BNO =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sDTO.getbTitle());
			ps.setString(2, sDTO.getbContent());
			ps.setInt(3, sDTO.getbNo());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, null);
		}
	}//delete Simple
	public void deleteSimple(int bNo) {
		try {
			conn =ds.getConnection();
			sql ="DELETE FROM SIMPLE WHERE BNO=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bNo);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, null);
		}
	}//5. insertSimple()
	public void insert(SimpleDTO sDTO) {
		try {
			conn = ds.getConnection();
			sql ="INSERT INTO SIMPLE (BNO, BWRITER, BTITLE, BCONTENT, BDATE) VALUES (SIMPLE_SEQ.NEXTVAL, ?,?,?,SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sDTO.getbWriter());
			ps.setString(2, sDTO.getbContent());
			ps.setInt(3, sDTO.getbNo());
			ps.executeUpdate(); //실행!
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, null);
		}
	}
}



