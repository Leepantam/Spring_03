package com.leepantam.s3.member;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.leepantam.s3.member.MemberDAO";
	
	public int memberJoin(MemberDTO mDto) throws Exception {
		return sqlSession.insert(NAMESPACE+".memberJoin",mDto);
	}
	
	
	public MemberDTO memberLogin(MemberDTO mDto) throws Exception {
		mDto=new MemberDTO();
		mDto.setId("test0323");
		mDto.setPw("test0323");
		mDto = sqlSession.selectOne(NAMESPACE+".memberLogin", mDto);
		
		return mDto;
	}
	
	
//	public int memberDelete(MemberDTO mDto) throws Exception{
//		int result;
//		return result;
//	}
//	
//	public int memberUpdate(MemberDTO mDto) throws Exception{
//		int result;
//		return result;
//	}
	
}
