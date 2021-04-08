package com.leepantam.s3.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.leepantam.s3.util.Pager;

public interface BoardService {


	//list
	public abstract List<BoardDTO> getList(Pager pager)throws Exception;


	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;


	//글 작성
	//제목, 내용
	public int setInsert(BoardDTO boardDTO,MultipartFile[] files) throws Exception;

	//글 수정
	//제목, 내용
	public int setUpdate(BoardDTO boardDTO) throws Exception;

	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;

}
