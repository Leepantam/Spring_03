package com.leepantam.s3.board;

import java.util.List;

import com.leepantam.s3.util.Pager;

public interface BoardDAO {
	//상수, 추상메서드
	//	접근지정자 => public abstract (둘다 생략 가능)
	
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception; 
	
	//전체 글의 갯수
	public long getTotalCount(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//hit update
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 작성
	//제목, 내용
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 수정
	//제목, 내용
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;

}
