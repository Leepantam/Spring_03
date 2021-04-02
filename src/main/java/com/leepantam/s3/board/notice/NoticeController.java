package com.leepantam.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.member.MemberDTO;
import com.leepantam.s3.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	
	@Autowired
	private NoticeService nServ;
	
	
	
	@RequestMapping(value="noticeList")
	public ModelAndView getList(HttpSession session,Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		List<BoardDTO> array = nServ.getList(pager);
		mv.addObject("list", array);
		mv.addObject("board","notice");
		mv.setViewName("board/boardList");
		
		return mv;
//		session.setAttribute("noticeList", array);
//		session.setAttribute("pager", pager);
	}
	
	@RequestMapping(value="noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDto) throws Exception{
		boardDto = nServ.getSelect(boardDto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardDto);
		mv.addObject("path", "notice");
		mv.setViewName("board/boardSelect");
		
		
		return mv;
	}
	
	@RequestMapping(value="noticeDelete")
	public String setDelete(NoticeDTO nDto) throws Exception{
		int result = nServ.setDelete(nDto);
		
		return "redirect:./noticeList";
	}
	
	
	@RequestMapping(value="noticeInsert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
		
	}
	
	@RequestMapping(value="noticeInsert",method=RequestMethod.POST)
	public String setInsert(BoardDTO boardDto,HttpSession session,Model model) throws Exception{
		boardDto.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		int result = nServ.setInsert(boardDto);
		String message = "실패";
		String path = "./noticeList";
		if(result>0) {
			message="성공";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}
	
	@GetMapping(value="noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDto,ModelAndView mv) throws Exception{
		boardDto = nServ.getSelect(boardDto);
		mv.addObject("dto", boardDto);
		mv.addObject("path", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
	}
	@PostMapping(value="noticeUpdate")
	public String setUpdate(BoardDTO boardDto) throws Exception{
		int result = nServ.setUpdate(boardDto);
		return "redirect:./noticeList";
	}
	
	
}
