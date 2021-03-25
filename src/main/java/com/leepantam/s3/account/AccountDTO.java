package com.leepantam.s3.account;

import java.sql.Date;

public class AccountDTO {
	private String user_info;
	private String account;
	private int book_info;
	private Date make_date;
	private int balance;
	public String getUser_info() {
		return user_info;
	}
	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBook_info() {
		return book_info;
	}
	public void setBook_info(int book_info) {
		this.book_info = book_info;
	}
	
	public Date getMake_date() {
		return make_date;
	}
	public void setMake_date(Date make_date) {
		this.make_date = make_date;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}