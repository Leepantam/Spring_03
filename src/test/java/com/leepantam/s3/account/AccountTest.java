package com.leepantam.s3.account;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;

public class AccountTest extends MyAbstractTest {
	
	@Autowired
	private AccountDAO aDao;

	@Test
	public void setInsertTest() throws Exception {
		AccountDTO aDto = new AccountDTO();
		aDto.setUser_info("user01");
		aDto.setAccount("999-999999-99-999");
		aDto.setBook_info(3);
		
		int result = aDao.setInsert(aDto);
		assertNotEquals(0, result);
	}
	
//	@Test
//	public void getListTest() throws Exception {
//		AccountDTO aDto = new AccountDTO();
//		aDto.setUser_info("user01");
//		
//		List<AccountDTO> array= aDao.getList(aDto);
//		assertNotEquals(0,array);
//	}

}
