package com.leepantam.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value="qnaInsert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board","qna");
		
		return mv;
	}
	
	@PostMapping(value="qnaInsert")
	public ModelAndView setInsert(BoardDTO boardDto) throws Exception{
		int result = qServ.setInsert(boardDto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./qnaList");
		return mv;
		
	}
	
	@GetMapping(value="qnaSelect")
	public ModelAndView getSelect(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDto = qServ.getSelect(boardDto);
		mv.addObject("board", "qna");
		mv.addObject("dto", boardDto);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping(value="qnaReply")
	public ModelAndView setReply()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		return mv;
	}
	@PostMapping(value="qnaReply")
	public ModelAndView setReply(QnaDTO qnaDto)throws Exception{
		ModelAndView mv = new ModelAndView();
		qServ.setReply(qnaDto);
		mv.setViewName("redirect:./qna/qnaList");
		return mv;
	}
	
	
	
	@PostMapping(value="qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qServ.setDelete(boardDto);
		String message = "실패";
		String path = "./qnaList";
		if(result>0) {
			message = "성공";
		}
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
	
	@GetMapping(value="qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDto)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDto = qServ.getSelect(boardDto);
		mv.addObject("dto", boardDto);
		mv.setViewName("board/boardUpdate");
		mv.addObject("board","qna");
		
		return mv;
	}
	
	@PostMapping(value="qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDto, ModelAndView mv) throws Exception{
		int result = qServ.setUpdate(boardDto);
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg","실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
}
