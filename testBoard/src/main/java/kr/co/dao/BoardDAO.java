package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;
import kr.co.vo.PageTO;

public interface BoardDAO {

	// 게시글 작성
	public void write(BoardVO boardVO) throws Exception;

	public List<BoardVO> list();

	public BoardVO read(int bno);

	public void update(BoardVO boardVO);

	public void delete(int bno);

	public PageTO list(PageTO to);

	public List<BoardVO> searchList(String searchType, String keyword);
}