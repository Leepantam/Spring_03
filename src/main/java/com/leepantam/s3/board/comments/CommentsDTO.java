package com.leepantam.s3.board.comments;

import java.sql.Date;

public class CommentsDTO {
	private long commentsnum;
	private long num;
	private String writer;
	private String contents;
	private Date regdate;
	public long getCommentsnum() {
		return commentsnum;
	}
	public void setCommentsnum(long commentsnum) {
		this.commentsnum = commentsnum;
	}	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
