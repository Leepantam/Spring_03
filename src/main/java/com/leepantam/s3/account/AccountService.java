package com.leepantam.s3.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.member.MemberDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO aDao;
	
	public List<AccountDTO> getList(MemberDTO memberDTO) throws Exception {
		return aDao.getList(memberDTO);
	}
}
