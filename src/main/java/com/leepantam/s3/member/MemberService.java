package com.leepantam.s3.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.leepantam.s3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO mDao;
	
	@Autowired
	private FileManager fMana;
	
	public int memberJoin(MemberDTO mDto, MultipartFile avatar,HttpSession session) throws Exception{
		
		fMana.save("member", avatar, session);
//		return mDao.memberJoin(mDto);
		
		return 0;
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
