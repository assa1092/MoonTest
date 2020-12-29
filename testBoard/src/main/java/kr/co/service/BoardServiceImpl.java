package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dao.BoardDAO;
import kr.co.util.FileUtils;
import kr.co.vo.BoardVO;
import kr.co.vo.PageTO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	private BoardDAO dao;

	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception{
		dao.write(boardVO);
		
		
		
	}

	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}

	@Override
	public PageTO list(PageTO to) throws Exception {
		return dao.list(to);
	}

	@Override
	public List<BoardVO> searchList(String searchType, String keyword) {
		return dao.searchList(searchType, keyword);
	}

}
