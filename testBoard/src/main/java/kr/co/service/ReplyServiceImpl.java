package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.ReplyDAO;
import kr.co.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDAO rDao;

	@Override
	public int insert(ReplyVO vo) {
		return rDao.insert(vo);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		return rDao.list(bno);
	}

}
