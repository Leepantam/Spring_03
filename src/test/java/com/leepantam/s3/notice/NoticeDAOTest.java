package com.leepantam.s3.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;
import com.leepantam.s3.board.notice.NoticeDAO;
import com.leepantam.s3.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO nDao;

	//	@Test
	public void getSelectTest() throws Exception{
		NoticeDTO nDto = new NoticeDTO();
		nDto.setNum(0);
//		nDto = nDao.getSelect(nDto);

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

	@Test
	public void setInsert() throws Exception{
		for(int i=0; i<120;i++) {

			NoticeDTO nDto = new NoticeDTO();
			nDto.setTitle("title"+i);
			nDto.setContents("contents"+i);
			nDto.setWriter("mustDEL"+i);
			int result = nDao.setInsert(nDto);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}

		//		assertNotEquals(0, result);
	}

	//	@Test
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
