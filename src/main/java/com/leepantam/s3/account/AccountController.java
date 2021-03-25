package com.leepantam.s3.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	
	@RequestMapping(value="accountList")
	public void accountList() {
		
	}
}
