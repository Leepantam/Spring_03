package com.leepantam.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

	@Autowired
	private CommentsDAO cDao;
	
	public List<CommentsDTO> getList(CommentsDTO cDto) throws Exception{
		return cDao.getList(cDto);
	}
}
