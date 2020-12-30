package kr.co.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.service.BoardService;
import kr.co.vo.BoardDTO;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// 업로드 폴더 경로 
	// 보통은 프로젝트 안에 /src/main/webapp/resources/upload 이렇게 만든다.
	private String uploadPath = "C:" + File.separator + "upload";
	
	@Inject
	private BoardService bService;
	
	// 첨부파일 글쓰기
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard(BoardDTO dto) throws Exception{
		// 파일 업로드 처리
		String fileName = null;
		MultipartFile uploadFile = dto.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			// 확장자 구하기
			String ext = FilenameUtils.getExtension(originalFileName);
			// UUID 구하기
			UUID uuid = UUID.randomUUID();
			
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File(uploadPath + fileName));
			
		}
		dto.setFileName(fileName);
		bService.insertBoard(dto);
		
		return "";
	}
	
//	@ResponseBody
//	@RequestMapping (value = "/getAttach/{bno}", method = RequestMethod.GET)
//	public List<String> getAttach(@PathVariable("bno") Integer bno){
//		logger.info("getAttach");
//		return bService.getAttach(bno);
//	}
//	
	
	
	
}
