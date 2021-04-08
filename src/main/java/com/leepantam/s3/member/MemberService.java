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
		
		String fileName = fMana.save("member", avatar, session);
		MemberFileDTO mfDto = new MemberFileDTO();
		mfDto.setId(mDto.getId());
		mfDto.setOrigineName(avatar.getOriginalFilename());
		mfDto.setFileName(fileName);
		int result = mDao.memberJoin(mDto);
		result = mDao.memberFileInsert(mfDto);
		
		return result;
	}
	
	public MemberDTO memberLogin(MemberDTO mDto) throws Exception{
		mDto = mDao.memberLogin(mDto);
//		MemberFileDTO mfDto = mDao.memberLoginFile(mDto);
//		mDto.setMemberFileDTO(mfDto);
		return mDto;
	}
	
	public int memberDelete(MemberDTO mDto, HttpSession session) throws Exception{
		MemberFileDTO mfDto = mDao.getMemberFile(mDto);
		boolean check = fMana.Delete("member", mfDto.getFileName(), session);
		
		return mDao.memberDelete(mDto);
	}
	
	public int memberUpdate(MemberDTO mDto) throws Exception{
		return mDao.memberUpdate(mDto);
	}
}
