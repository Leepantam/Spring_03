package com.leepantam.s3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		int result=mServ.memberJoin(mDto);
		return "redirect:../";
	}
	
	
	@RequestMapping(value="memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO mDto,HttpSession session) throws Exception {
		mDto = mServ.memberLogin(mDto);
		session.setAttribute("member", mDto);
		return "redirect:../";
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="memberPage")
	public void memberPage(HttpSession session) throws Exception{
		
	}
}
