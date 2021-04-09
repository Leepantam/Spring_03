package com.leepantam.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO mDAO;

//	@Test
	public void memberJoinTest() throws Exception {
		MemberDTO mDto = new MemberDTO();
		mDto.setId("test0323");
		mDto.setPw("test0323");
		mDto.setName("test323");
		mDto.setPhone("01011112222");
		mDto.setEmail("test323@test.com");
		int result = mDAO.memberJoin(mDto);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	public void memberLoginTest() throws Exception{
		MemberDTO mDto=new MemberDTO();
		mDto.setId("user04");
		mDto.setPw("user04");
		mDto = mDAO.memberLogin(mDto);
		
		assertNotNull(mDto);
		System.out.println(mDto.getName());
		
	}
	
//	@Test
	public void memberDeleteTest() throws Exception{
		MemberDTO mDto = new MemberDTO();
		mDto.setId("7");
		int result = mDAO.memberDelete(mDto);
		assertEquals(1, result);
	}
	
//	@Test
	public void memberUpdate() throws Exception{
		MemberDTO mDto = new MemberDTO();
		mDto.setId("user04");
		mDto.setPw("park");
		
		mDto=mDAO.memberLogin(mDto);
		mDto.setName("park");
		mDto.setPw("user04");
		
		int result = mDAO.memberUpdate(mDto);
		assertEquals(1, result);
		
		
	}
	
//	@Test
	public void memberFileInsert() throws Exception{
		MemberFileDTO mfDto = new MemberFileDTO();
		mfDto.setId("delTest");
		mfDto.setFileName("fileName");
		mfDto.setOrigineName("origineName");
		
		System.out.println(mfDto.getId());
		System.out.println(mfDto.getFileName());
		System.out.println(mfDto.getOrigineName());
		
		int result = mDAO.memberFileInsert(mfDto);
		assertNotEquals(0, result);
	}
	
	@Test
	public void memberIdCheckTest() throws Exception{
		MemberDTO mDto = new MemberDTO();
		mDto.setId("user01");
		
		mDto = mDAO.memberIdCheck(mDto);
		System.out.println(mDto);
	}

}
