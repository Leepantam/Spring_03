package com.leepantam.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leepantam.s3.member.MemberDTO;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	@Autowired
	private AccountService aServ;
	
	
	@RequestMapping(value="accountList")
	public void getList(HttpSession session, Model model) throws Exception {
		List<AccountDTO> array = aServ.getList((MemberDTO)session.getAttribute("member"));
		model.addAttribute("list", array);
	}
}
