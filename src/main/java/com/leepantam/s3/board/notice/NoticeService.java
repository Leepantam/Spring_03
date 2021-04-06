package com.leepantam.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.board.BoardService;
import com.leepantam.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO nDao;

	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		long totalCount = nDao.getTotalCount(pager);
		pager.makeRow();
		pager.makeNum(totalCount);
		
		
		return nDao.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		nDao.setHitUpdate(boardDTO);
		return nDao.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return nDao.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return nDao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return nDao.setDelete(boardDTO);
	}

	
}
