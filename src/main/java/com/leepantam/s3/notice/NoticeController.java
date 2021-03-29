package com.leepantam.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leepantam.s3.member.MemberDTO;
import com.leepantam.s3.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	
	@Autowired
	private NoticeService nServ;
	
	
	
	@RequestMapping(value="noticeList")
	public void getList(HttpSession session,Pager pager) throws Exception {
		System.out.println(pager.getCurPage());
		List<NoticeDTO> array = nServ.getList(pager);
		session.setAttribute("noticeList", array);
		session.setAttribute("pager", pager);
	}
	
	@RequestMapping(value="noticeSelect")
	public void getSelect(NoticeDTO nDto,Model model) throws Exception{
		nDto = nServ.getSelect(nDto);
		model.addAttribute("nDto", nDto);
		
	}
	
	@RequestMapping(value="noticeDelete")
	public String setDelete(NoticeDTO nDto) throws Exception{
		int result = nServ.setDelete(nDto);
		
		return "redirect:noticeList";
	}
	
	
	@RequestMapping(value="noticeInsert")
	public void setInsert() throws Exception{
		
	}
	
	@RequestMapping(value="noticeInsert",method=RequestMethod.POST)
	public String setInsert(NoticeDTO nDto,HttpSession session) throws Exception{
		nDto.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		int result = nServ.setInsert(nDto);
		return "redirect:noticeList";
	}
	
	@RequestMapping(value="noticeUpdate")
	public void setUpdate(NoticeDTO nDto,Model model) throws Exception{
		nDto = nServ.getSelect(nDto);
		model.addAttribute("nDto", nDto);
	}
	@RequestMapping(value="noticeUpdate",method = RequestMethod.POST)
	public String setUpdate(NoticeDTO nDto) throws Exception{
		int result = nServ.setUpdate(nDto);
		return "redirect:noticeList";
	}
	
	
}
