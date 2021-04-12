package com.leepantam.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/comments/**")
public class CommentsController {

	@Autowired
	private CommentsService cServ;
	
	@GetMapping(value="commentsList")
	public void getList(CommentsDTO cDto,Model model) throws Exception{
		System.out.println(cDto.getNum());
		List<CommentsDTO> array = cServ.getList(cDto);
		model.addAttribute("list", array);
	}
	
	@PostMapping(value="commentsInsert")
	public ModelAndView setInsert(CommentsDTO cDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = cServ.setInsert(cDto);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping(value="commentsDelete")
	public ModelAndView commentsDelete(int[] commentsNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("start");
		int result = cServ.setDelete(commentsNum);
		System.out.println("cont"+result);
		System.out.println("finish");
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
