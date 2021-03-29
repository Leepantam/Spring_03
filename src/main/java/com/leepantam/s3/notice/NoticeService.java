package com.leepantam.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO nDao;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		int perPage=10;
		
		long startRow=(pager.getCurPage()*perPage)-(perPage-1);
		long lastRow = (pager.getCurPage()*perPage);
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		
		long totalCount = 120;
		long totalPage=totalCount/perPage;
		
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		pager.setTotalPage(totalPage);
		System.out.println("TotalPage : "+totalPage);
		return nDao.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO nDto) throws Exception{
		nDao.setHitUpdate(nDto);
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
