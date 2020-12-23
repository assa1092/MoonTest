package kr.co.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO mDao;

	@Override
	public void register(MemberVO vo) throws Exception{
		mDao.register(vo);		
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception{
		return mDao.login(vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		mDao.memberUpdate(vo);
		
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		mDao.memberDelete(vo);
		
	}

	@Override
	public int passCheck(MemberVO vo) throws Exception {
		return mDao.passCheck(vo);
	}
}
