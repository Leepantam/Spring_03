package com.leepantam.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leepantam.s3.board.BoardDAO;
import com.leepantam.s3.board.BoardDTO;
import com.leepantam.s3.board.BoardFileDTO;
import com.leepantam.s3.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.leepantam.s3.board.notice.NoticeDAO";
	
	
	public int setFileDelete(BoardFileDTO bfDto) throws Exception{
		return sqlSession.delete(NAMESPACE+".setFileDelete", bfDto);
	}
	
	public BoardFileDTO getFileName(BoardFileDTO bfDto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".getFileName",bfDto);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getList", pager);
	}
	@Override
	public long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getTotalCount",pager);
	}
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getSelect", boardDTO);
	}
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+".setHitUpdate", boardDTO);
	}
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+".setInsert", boardDTO);
	}
	
	public int setFileInsert(BoardFileDTO bfDto)throws Exception{
		return sqlSession.insert(NAMESPACE+".setFileInsert",bfDto);
	}
	
	public long getNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".getNum");
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+".setUpdate", boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+".setDelete", boardDTO);
	}
	


}
