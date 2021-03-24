package com.leepantam.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bDao;
	
	public List<BankBookDTO> getList() throws Exception {
		return bDao.getList();
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
