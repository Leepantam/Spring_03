package com.leepantam.s3.board.qna;

import java.util.List;

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
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qDao;
	
	@Autowired
	private FileManager fMana;
	
	@Autowired
	private HttpSession session;
	
	public int setReply(QnaDTO qnaDto) throws Exception{
		//부모글의 ref,step,depth 조회
		BoardDTO boardDto = qDao.getSelect(qnaDto);
		QnaDTO p = (QnaDTO)boardDto;
		System.out.println(p.getRef());
		System.out.println(p.getStep());
		System.out.println(p.getDepth());
		
		qnaDto.setRef(p.getRef());
		qnaDto.setStep(p.getStep()+1);
		qnaDto.setDepth(p.getDepth()+1);
		
		qDao.setReplyUpdate(qnaDto);
		int result = qDao.setReply(qnaDto);
		
		return result;
		
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		int perPage=10;
		int perBlock=5;
		
		pager.makeRow();
				
		long totalCount = qDao.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		
		return qDao.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = qDao.setHitUpdate(boardDTO);
		return qDao.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		int result = qDao.setInsert(boardDTO);
		
		for(MultipartFile mf : files) {
			 BoardFileDTO bfDto = new BoardFileDTO();
			 String fileName = fMana.save("qna", mf, session);
			 bfDto.setNum(boardDTO.getNum());
			 bfDto.setFileName(fileName);
			 bfDto.setOrigineName(mf.getOriginalFilename());
			 qDao.setFileInsert(bfDto);
		}
		
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qDao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qDao.setDelete(boardDTO);
	}

	
}
