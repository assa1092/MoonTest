package kr.co.dao;

import java.util.List;

import kr.co.vo.ReplyVO;

public interface ReplyDAO {

	int insert(ReplyVO vo);

	List<ReplyVO> list(int bno);

	int update(ReplyVO vo);

	int delete(int rno);

}
