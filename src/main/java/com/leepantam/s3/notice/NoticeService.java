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

		// 1. totalCount  - 전체 글 수 확인
		long totalCount = nDao.getTotalCount(pager);
		
		// 2. totalPage  - 전체 페이지수 확인
		long totalPage=totalCount/perPage;

		if(totalCount%perPage!=0) {
			totalPage++;
		}
		// 3. totalBlock  - 전체 블럭 수 확인
		long totalBlock = totalPage/perBlock;
		if(totalPage%5!=0) {
			totalBlock++;
		}

		// 4. curBlock  - 현재 블럭 위치 확인
		long curBlock = pager.getCurPage()/5;

		if(pager.getCurPage()%5!=0){
			curBlock++;
		}
		// 5. startNum,lastNum 구하기
		long startNum=(curBlock*perBlock)-(perBlock-1);
		long lastNum=curBlock*perBlock;
		
		// 6. curBlock이 totalBlock일 때 마지막으로 글이 있는 페이지까지만 표시
		if(curBlock == totalBlock) {
			lastNum=totalPage;
		}
		
		// 7. 이전, 다음 block의 존재 여부
		// 이전
		if(curBlock != 1) {
			pager.setPre(true);
		}
		// 다음
		if(curBlock != totalBlock) {
			pager.setNext(true);
		}
		
		
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
