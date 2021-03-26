package com.leepantam.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.member.MemberDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO aDao;
	private int num=100000;
	
	public List<AccountDTO> getList(AccountDTO aDto) throws Exception {

		return aDao.getList(aDto);
	}
	
	public int setInsert(AccountDTO aDto)throws Exception{
		num=++num;
		StringBuffer sb = new StringBuffer();
		sb.append("111-");
		sb.append(num);
		sb.append("-22-");
		sb.append("333");
		aDto.setAccount(sb.toString());
		return aDao.setInsert(aDto);
	}
}
