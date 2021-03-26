package com.leepantam.s3.account;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;

public class AccountServiceTest extends MyAbstractTest {

	@Autowired
	private AccountService aServ;
	
	@Test
	public void setInsertTest() throws Exception {
		aServ.setInsert(null);
	}

}
