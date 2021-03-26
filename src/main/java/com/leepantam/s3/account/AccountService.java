package com.leepantam.s3.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.member.MemberDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO aDao;
//	private int num=100000;
	
	public List<AccountDTO> getList(AccountDTO aDto) throws Exception {

		return aDao.getList(aDto);
	}
	
	public int setInsert(AccountDTO aDto)throws Exception{
		
		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		System.out.println(time);
//		
//		String t = time+"";
//		t = String.valueOf(time);
//		
//		String result = t.substring(0,4)+"-";
//		result = result+t.substring(4,8)+"-";
//		result = result+t.substring(8);
//		
//		System.out.println(result);
		
		//SimpleDateFormat
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd-HHmmss-S");
		String r = sd.format(ca.getTime());
		aDto.setAccount(r);
//		
//		String name = UUID.randomUUID().toString();
//		System.out.println(name);
		
		// 내가 한거
//		num=++num;
//		StringBuffer sb = new StringBuffer();
//		sb.append("111-");
//		sb.append(num);
//		sb.append("-22-");
//		sb.append("333");
//		aDto.setAccount(sb.toString());
		
		
		return aDao.setInsert(aDto);
//		return 0;
	}
}
