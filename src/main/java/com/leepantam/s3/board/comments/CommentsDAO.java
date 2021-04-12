package com.leepantam.s3.board.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.leepantam.s3.board.comments.CommentsDAO";
	
	public List<CommentsDTO> getList(CommentsDTO cDto)throws Exception{
		return sqlSession.selectList(NAMESPACE+".getList", cDto);
	}
	
	public int setInsert(CommentsDTO cDto) throws Exception{
		return sqlSession.insert(NAMESPACE+".setInsert", cDto);
	}
	public int setDelete(CommentsDTO cDto) throws Exception{
		return sqlSession.delete(NAMESPACE+".setDelete", cDto);
	}
}
