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
	
	@RequestMapping(value="memberJoinCheck")
	public void memberJoinCheck() throws Exception{
		
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
	public void memberPage() throws Exception{

	}

	@RequestMapping(value="memberDelete")
	public String memberDelete(HttpSession session) throws Exception{
		int result = mServ.memberDelete((MemberDTO)session.getAttribute("member"));

		session.invalidate();

		return "redirect:../";
	}

	@RequestMapping(value="memberUpdate")
	public void memberUpdate() throws Exception{

	}

	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(MemberDTO mDto, HttpSession session) throws Exception{
		int result = mServ.memberUpdate(mDto);

		if(result>0) {			
			session.setAttribute("member", mDto);
		}

		return "redirect:../";
	}
}
