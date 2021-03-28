package com.leepantam.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.leepantam.s3.notice.NoticeDAO";
	
	public List<NoticeDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+".getList");
	}
	
	public NoticeDTO getSelect(NoticeDTO nDto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".getSelect", nDto);
	}
	
	public int setDelete(NoticeDTO nDto) throws Exception{
		return sqlSession.delete(NAMESPACE+".setDelete", nDto);
	}
	
	public int setInsert(NoticeDTO nDto) throws Exception{
		return sqlSession.insert(NAMESPACE+".setInsert", nDto);
	}
	
	public int setUpdate(NoticeDTO nDto) throws Exception{
		nDto.setHit(nDto.getHit()-1);
		sqlSession.update(NAMESPACE+".setUpdate", nDto);
		return sqlSession.update(NAMESPACE+".setUpdate", nDto);
	}
	public int setHitUpdate(NoticeDTO nDto) throws Exception{
		return sqlSession.update(NAMESPACE+".setHitUpdate", nDto);
	}

}
