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
	
	public int setInsert(CommentsDTO cDto) throws Exception{
		return cDao.setInsert(cDto);
	}
	
	public int setDelete(int[] commentsNum) throws Exception{
		int result = 0;
		for (int i=0; i<commentsNum.length;i++) {
			CommentsDTO cDto = new CommentsDTO();
			int num=commentsNum[i];
			cDto.setCommentsNum(num);
			result = cDao.setDelete(cDto);
			System.out.println("serv:"+ result);
		}
		return result;
	}
}
