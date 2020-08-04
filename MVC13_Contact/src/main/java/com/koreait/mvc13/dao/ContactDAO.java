package com.koreait.mvc13.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.mvc13.common.Constant;
import com.koreait.mvc13.dto.ContatctDTO;
public class ContactDAO {
	private JdbcTemplate template; 
	public ContactDAO() {
		this.template = Constant.template;
	}
	//ContactListCommand 에서 호출할 selectContactList 
	public ArrayList<ContatctDTO> selectContactList(){
		String sql = "SELECT CNO, CNAME, CPHONE, CADDRESS, CEMAIL, CNOTE FROM CONTACT";
		ArrayList<ContatctDTO> list = (ArrayList<ContatctDTO>)template.query(sql, new BeanPropertyRowMapper<ContatctDTO>(ContatctDTO.class));
		return list;
		
	}//ContactViewCommand에서 호출할 selectContactBycNo() 
	public ContatctDTO selectContactBycNo(int cNo) {
		String sql = "SELECT CNO, CNAME, CPHONE, CADDRESS, CEMAIL, CNOTE FROM CONTACT WHERE CNO = " +cNo;
		ContatctDTO cDTO = template.queryForObject(sql, new BeanPropertyRowMapper<ContatctDTO>(ContatctDTO.class));
		return cDTO;
		
	}//ContactInsertCommand에서 호출할 contactInsert() 
	public void contactInsert(final String cName, final String cPhone, final String cAddress, final String cEmail, final String cNote) {
		template.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		String sql=
		"INSERT INTO CONTACT(CNO, CNAME, CPHONE, CADDRESS, CEMAIL, CNOTE) VALUES (CONTACT_SEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cName);
		ps.setString(2, cPhone);
		ps.setString(3, cAddress);
		ps.setString(4, cEmail);
		ps.setString(5, cNote);
		
		return ps;
			}
		});
	} //ContactDeleteCommand에서 호출할 contactDelete() 
	public void contactDelete(final int cNo) {
		String sql = "DELETE FROM CONTACT WHERE CNO = ?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, cNo);
			
			}
		});
	}//ContactUpdateCommand에서 호출할 contactUpdate() 
		public void contactUpdate(final String cName, final String cPhone, final String cAddress, final String cEmail, final String cNote , final int cNo) {
			String sql ="UPDATE CONTACT SET CNAME=?, CPHONE=?, CADDRESS=?, CEMAIL=?, CNOTE=? WHERE CNO=?";
			template.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, cName);
					ps.setString(2, cPhone);
					ps.setString(3, cAddress);
					ps.setString(4, cEmail);
					ps.setString(5, cNote);
					ps.setInt(6, cNo);
				}
			});
		}
	}

















