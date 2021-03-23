package com.leepantam.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO;

//	@Test
	public void memberJoinTest() throws Exception {
		MemberDTO mDto = new MemberDTO();
		mDto.setId("test0323");
		mDto.setPw("test0323");
		mDto.setName("test323");
		mDto.setPhone("01011112222");
		mDto.setEmail("test323@test.com");
		int result = memberDAO.memberJoin(mDto);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void memberLoginTest() throws Exception{
		MemberDTO mDto =  memberDAO.memberLogin(null);
		
		assertNotNull(mDto);
		System.out.println(mDto.getName());
		
	}

}
