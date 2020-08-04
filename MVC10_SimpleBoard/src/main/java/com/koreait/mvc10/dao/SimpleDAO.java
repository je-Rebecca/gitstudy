package com.koreait.mvc10.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.koreait.mvc10.dto.SimpleDTO;
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
	} 	// 실제 DB 처리하는 메소드  
	public ArrayList<SimpleDTO> simpleList(){
		ArrayList<SimpleDTO> list = new ArrayList<SimpleDTO>();
		try {
			conn = ds.getConnection();
			sql ="SELECT BNO, BWRITER, BTITLE, BCONTENT,BDATE FROM SIMPLE";
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery(); //SELECT 는 executeQuery()! 
			while(rs.next()) {
				int bNo = rs.getInt("BNO"); //rs.getInt(1)
				String bWriter = rs.getString("BWRITER"); //rs.getString(2) 
				String bTitle = rs.getString("BTITLE"); //칼럼 순서알면 숫자
				String bContent = rs.getString("BCONTENT"); //넣어도됨 
				Date bDate = rs.getDate("BDATE"); //이때 숫자는 무조건 1부터시작
				SimpleDTO sDTO = new SimpleDTO(bNo, bWriter, bTitle, bContent, bDate);
				list.add(sDTO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {close(conn, ps, rs);}
		return list; 
	}
	//2.SimpleInsertCommand가 호출할 simpleInsert()메소드 
	//매개변수(String bWriter, String bTitle, String bContent) 이건
	//SimpleInsertCommand클래스에서 받아옴 
	public void simpleInsert(String bWriter, String bTitle, String bContent) {
		try {
			conn = ds.getConnection();
			sql ="INSERT INTO SIMPLE (BNO, BWRITER, BTITLE, BCONTENT,BDATE) VALUES (SIMPLE_SEQ.NEXTVAL, ?,?,?,SYSDATE)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, bWriter);
			ps.setString(2, bTitle);
			ps.setString(3, bContent);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally { //rs는 select에서만 사용! 
			close(conn, ps, null);
		}
	}//3 simpleViewCommand가 호출할 simpleView() 
	public SimpleDTO simpleView(int bNo) {
		SimpleDTO sDTO = null;
		try {
			conn=ds.getConnection();
			sql="SELECT BNO, BWRITER, BTITLE, BCONTENT,BDATE FROM SIMPLE WHERE BNO = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bNo);
			rs= ps.executeQuery();
			if(rs.next()) {
				String bWriter = rs.getString("BWRITER"); //rs.getString(2) 
				String bTitle = rs.getString("BTITLE"); //칼럼 순서알면 숫자
				String bContent = rs.getString("BCONTENT"); //넣어도됨 
				Date bDate = rs.getDate("BDATE"); //이때 숫자는 무조건 1부터시작
				sDTO = new SimpleDTO(bNo, bWriter, bTitle, bContent, bDate);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return sDTO;
	}//4 simpleUpdateCommand가 호출할 simpleUpdate() 
	public void simpleUpdate(int bNo, String bTitle, String bContent) {
		try {
			conn = ds.getConnection();
			sql="UPDATE SIMPLE SET BTITLE =?, BCONTENT =? WHERE BNO= ? ";
			ps= conn.prepareStatement(sql);
			ps.setString(1, bTitle);
			ps.setString(2, bContent);
			ps.setInt(3, bNo);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, null);
		}
	}//5 simpleDeleteCommand가 호출할 simpleDelete() 
	public void simpleDelete(int bNo) {
		try {
			conn= ds.getConnection();
			sql="DELETE FROM SIMPLE WHERE BNO =?"; 
			ps= conn.prepareStatement(sql);
			ps.setInt(1, bNo);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
	
	}
	
	
	
}



