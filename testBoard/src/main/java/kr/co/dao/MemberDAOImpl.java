package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession session;
	
	private final String NS = "memberMapper";
	
	@Override
	public void register(MemberVO vo) throws Exception{
		session.insert(NS + ".register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return session.selectOne(NS+".login", vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		session.update(NS + "memberUpdate", vo);		
	} 

}
