package com.leepantam.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leepantam.s3.bankbook.BankBookDTO;
import com.leepantam.s3.member.MemberDTO;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	@Autowired
	private AccountService aServ;
	
	
	@RequestMapping(value="accountList")
	public void getList(AccountDTO aDto,HttpSession session, Model model) throws Exception {
		aDto.setUser_info(((MemberDTO)session.getAttribute("member")).getId());
		List<AccountDTO> array = aServ.getList(aDto);
		model.addAttribute("list", array);
	}
	
	@RequestMapping(value="accountInsert")
	public String setInsert(AccountDTO aDto,HttpSession session, BankBookDTO bDto) throws Exception{
		aDto.setUser_info(((MemberDTO)session.getAttribute("member")).getId());
		aDto.setBook_info(bDto.getAccount_number());
		aServ.setInsert(aDto);
		return "redirect:./accountList";
	}
}
