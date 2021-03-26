package com.leepantam.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO nDao;
	
	public List<NoticeDTO> getList() throws Exception{
		return nDao.getList();
	}
	
	public NoticeDTO getSelect(NoticeDTO nDto) throws Exception{
		return nDao.getSelect(nDto);
	}
	
	public int setDelete(NoticeDTO nDto) throws Exception{
		return nDao.setDelete(nDto);
	}
	
	public int setInsert(NoticeDTO nDto) throws Exception{
		return nDao.setInsert(nDto);
	}
	
	public int setUpdate(NoticeDTO nDto) throws Exception{
		return nDao.setUpdate(nDto);
	}
}
