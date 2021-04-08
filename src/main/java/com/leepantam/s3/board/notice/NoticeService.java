package com.leepantam.s3.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.board.BoardFileDTO;
import com.leepantam.s3.board.BoardService;
import com.leepantam.s3.util.FileManager;
import com.leepantam.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO nDao;
	
	@Autowired
	private FileManager fMana;
	
	@Autowired
	private HttpSession session;
	
	

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
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		long num=nDao.getNum();
		boardDTO.setNum(num);
		int result = nDao.setInsert(boardDTO);
		// 글번호 찾기
		for(MultipartFile mf : files) {
			BoardFileDTO bfDto = new BoardFileDTO();
			String fileName = fMana.save("notice", mf, session);
			bfDto.setNum(num);
			bfDto.setFileName(fileName);
			bfDto.setOrigineName(mf.getOriginalFilename());
			nDao.setFileInsert(bfDto);
		}
		
		return result;
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
