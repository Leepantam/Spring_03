package com.leepantam.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO mDao;
	
	public int memberJoin(MemberDTO mDto) throws Exception{
		return mDao.memberJoin(mDto);
	}
	
	public MemberDTO memberLogin(MemberDTO mDto) throws Exception{
		return mDao.memberLogin(mDto);
	}
	
	public int memberDelete(MemberDTO mDto) throws Exception{
		return mDao.memberDelete(mDto);
	}
	
	public int memberUpdate(MemberDTO mDto) throws Exception{
		return mDao.memberUpdate(mDto);
	}
}
