package com.koreait.finalproject.dto;

import java.sql.Date;

public class BoardDTO {
	private int bIx ;
	private String bWirter,bTitle, bContent;
	private Date bDate;
	
	public BoardDTO() {}
	
	public BoardDTO(int bIx, String bWirter, String bTitle, String bContent, Date bDate) {
		super();
		this.bIx = bIx;
		this.bWirter = bWirter;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}
	public int getbIx() {
		return bIx;
	}
	public void setbIx(int bIx) {
		this.bIx = bIx;
	}
	public String getbWirter() {
		return bWirter;
	}
	public void setbWirter(String bWirter) {
		this.bWirter = bWirter;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	
}
