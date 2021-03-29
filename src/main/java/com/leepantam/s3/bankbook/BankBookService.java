package com.leepantam.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bDao;
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
		
		long perPage=10;
		long perBlock=5;
		long startRow=(pager.getCurPage()*perPage)-(perPage-1);
		long lastRow=(pager.getCurPage()*perPage);
		
		//1.totalCount
		long totalCount=bDao.getTotalBankBook();
		//2.totalPage
		long totalPage = totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		//3.totlaBlock
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//4.curBlock
		long curBlock = pager.getCurPage()/5;
		if(pager.getCurPage()%5!=0) {
			curBlock++;
		}
		//5.startNum,lastNum
		long startNum=(curBlock*perBlock)-(perBlock-1);
		long lastNum=curBlock*perBlock;
		
		pager.setLastNum(lastNum);
		pager.setLastRow(lastRow);
		pager.setStartNum(startNum);
		pager.setStartRow(startRow);
		
		return bDao.getList(pager);
	}
	
	public BankBookDTO getSelect(BankBookDTO bDto) throws Exception {
		return bDao.getSelect(bDto);
	}
	
	public int setDelete(BankBookDTO bDto) throws Exception {
		return bDao.setDelete(bDto);
	}
	
	public int setWrite(BankBookDTO bDto) throws Exception{
		return bDao.setWrite(bDto);
	}
	
	public int setUpdate(BankBookDTO bDto) throws Exception{
		return bDao.setUpdate(bDto);
	}
	
	
}
