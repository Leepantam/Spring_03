package com.leepantam.s3.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO nDao;
	
//	@Test
	public void getSelectTest() throws Exception{
		NoticeDTO nDto = new NoticeDTO();
		nDto.setNum(0);
		nDto = nDao.getSelect(nDto);
		
		assertNotNull(nDto);
		System.out.println(nDto.getContents());
	}
	
//	@Test
	public void setDeleteTest() throws Exception{
		NoticeDTO nDto = new NoticeDTO();
		nDto.setNum(0);
		
		int result = nDao.setDelete(nDto);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	public void setInsert() throws Exception{
		NoticeDTO nDto = new NoticeDTO();
		nDto.setTitle("title");
		nDto.setContents("contents");
		nDto.setWriter("mustDEL");
		int result = nDao.setInsert(nDto);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void setUpdateTest() throws Exception{
		NoticeDTO nDto = new NoticeDTO();
		nDto.setNum(1);
		nDto.setTitle("change_title");
		nDto.setContents("change");
		nDto.setWriter("mustDEL");
		nDto.setHit(80);
		
		int result = nDao.setUpdate(nDto);
		
		assertNotEquals(0, result);
	}
}
