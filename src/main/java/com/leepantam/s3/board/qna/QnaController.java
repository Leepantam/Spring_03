package com.leepantam.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	@Autowired
	private QnaService qServ;
	
	@GetMapping(value="qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> array=qServ.getList(pager);
		mv.addObject("list", array);
		mv.addObject("board","qna");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaInsert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board","qna");
		
		return mv;
	}
}
