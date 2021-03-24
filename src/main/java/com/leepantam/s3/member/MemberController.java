package com.leepantam.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Autowired
	private MemberService mServ;
	
	@RequestMapping(value="memberJoin")
	public void memberJoin() {
		
	}
	
	@RequestMapping(value="memberJoin",method=RequestMethod.POST)
	public String memberJoin(MemberDTO mDto) throws Exception {
		mServ.memberJoin(mDto);
		return "redirect:../";
	}
	
	
	@RequestMapping(value="memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO mDto) throws Exception {
		String result="/member/memberLogin";
		mDto = mServ.memberLogin(mDto);
		if(mDto!=null) {
			result="redirect:../";
		}
		return result;
	}

}
