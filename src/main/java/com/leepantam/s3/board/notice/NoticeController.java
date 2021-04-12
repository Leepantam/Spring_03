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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.board.BoardFileDTO;
import com.leepantam.s3.member.MemberDTO;
import com.leepantam.s3.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	
	@Autowired
	private NoticeService nServ;
	
	
	@GetMapping(value="fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO bfDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = nServ.setFileDelete(bfDto);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	@RequestMapping(value="noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> array = nServ.getList(pager);
		mv.addObject("list", array);
		mv.addObject("board","notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value="noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDto) throws Exception{
		boardDto = nServ.getSelect(boardDto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardDto);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		
		return mv;
	}

	
	@PostMapping(value="noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = nServ.setDelete(boardDto);
		String message = "실패";
		String path = "./noticeList";
		if(result>0) {
			message = "성공";
		}
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}

	
	@RequestMapping(value="noticeInsert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
		
	}
	
	@RequestMapping(value="noticeInsert",method=RequestMethod.POST)
	public String setInsert(BoardDTO boardDto,HttpSession session,Model model, MultipartFile [] files) throws Exception{
		boardDto.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		int result = nServ.setInsert(boardDto, files);
		
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
	public ModelAndView setUpdate(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDto = nServ.getSelect(boardDto);
		mv.addObject("dto", boardDto);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
	}
	
	
	@PostMapping(value="noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDto, MultipartFile [] files,ModelAndView mv) throws Exception{
		int result = nServ.setUpdate(boardDto, files);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}
	
	
}
