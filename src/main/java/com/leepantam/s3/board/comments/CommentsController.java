package com.leepantam.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void setInsert(CommentsDTO cDto) throws Exception{
		System.out.println(cDto.getWriter());
		System.out.println(cDto.getContents());
	}
	
}
