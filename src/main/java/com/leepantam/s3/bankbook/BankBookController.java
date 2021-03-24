package com.leepantam.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/**")
public class BankBookController {
	
	@Autowired
	private BankBookService bServ;

	@RequestMapping(value="bankbookList")
	public void getList(Model model) throws Exception {
		List<BankBookDTO> array = bServ.getList();
		model.addAttribute("list", array);
	}
	
	@RequestMapping(value="bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bDto) throws Exception {
		ModelAndView mv = new ModelAndView();
		bDto = bServ.getSelect(bDto);
		mv.addObject("dto", bDto);
		mv.setViewName("bankbook/bankbookSelect");
		return mv;
	}
	
	@RequestMapping(value="bankbookDelete")
	public String setDelete(BankBookDTO bDto) throws Exception{
		bServ.setDelete(bDto);
		
		return "redirect:bankbookList";
	}
}
