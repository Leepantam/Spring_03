package com.leepantam.s3.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leepantam.s3.util.Pager;

@Repository
public class BankBookDAO {
	//getList
	
	@Autowired
	private SqlSession sqlSession;
	
	
	private final String NAME_SPACE="com.leepantam.s3.bankbook.BankBookDAO";
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAME_SPACE+".getList",pager);
		
	}
	
	
	
	public BankBookDTO getSelect(BankBookDTO bDto) throws Exception {
		long num = 1L;
		bDto = sqlSession.selectOne(NAME_SPACE+".getSelect", bDto);
		
		return bDto;
		
	}
	
	public int setWrite(BankBookDTO bDto) throws Exception {
		int result = sqlSession.insert(NAME_SPACE+".setWrite", bDto);
		
		return result;
	}
	
	public int setDelete(BankBookDTO bDto) throws Exception {
		int result =sqlSession.delete(NAME_SPACE+".setDelete", bDto);
		
		return result;
	}
	
	public int setUpdate(BankBookDTO bDto) throws Exception{
		int result = sqlSession.update(NAME_SPACE+".setUpdate", bDto);
		
		return result;
	}
	
	public long getTotalBankBook(Pager pager) throws Exception{
		return sqlSession.selectOne(NAME_SPACE+".getTotalBankBook",pager);
	}
	
}
