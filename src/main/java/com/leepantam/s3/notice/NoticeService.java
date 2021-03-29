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
		int perBlock = 5;

		long startRow=(pager.getCurPage()*perPage)-(perPage-1);
		long lastRow = (pager.getCurPage()*perPage);

		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);

		// 1. totalCount
		long totalCount = nDao.getTotalCount();
		// 2. totalPage
		long totalPage=totalCount/perPage;

		if(totalCount%perPage!=0) {
			totalPage++;
		}
		// 3. totalBlock
		long totalBlock = totalPage/perBlock;
		if(totalPage%5!=0) {
			totalBlock++;
		}

		// 4. curBlock
		long curBlock = pager.getCurPage()/5;

		if(pager.getCurPage()%5!=0){
			curBlock++;
		}
		// 5. startNum,lastNum 구하기
		long startNum=(curBlock*perBlock)-(perBlock-1);
		long lastNum=curBlock*perBlock;
		
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);

		System.out.println("TotalPage : "+totalPage);
		System.out.println("TotalBlock : " + totalBlock);
		System.out.println("curBlock : "+curBlock);
		System.out.println("startNum : "+startNum);
		System.out.println("lastNum : "+ lastNum);
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
