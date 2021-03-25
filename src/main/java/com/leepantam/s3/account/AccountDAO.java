package com.leepantam.s3.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leepantam.s3.member.MemberDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.leepantam.s3.account.AccountDAO";
	
	public List<AccountDTO> getList(MemberDTO mDto) throws Exception {
		List<AccountDTO> arr = sqlSession.selectList(NAMESPACE+".getList", mDto);
		return arr;
	}
}
