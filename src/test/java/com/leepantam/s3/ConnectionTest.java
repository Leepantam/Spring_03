package com.leepantam.s3;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionTest extends MyAbstractTest {
	
	@Autowired
	private DataSource dataSource;
//	Main Branch Test
	@Autowired
	private SqlSession SqlSession;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(SqlSession);
	}
	
}
