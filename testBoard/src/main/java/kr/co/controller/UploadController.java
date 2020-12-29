package kr.co.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.service.BoardService;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// 업로드 폴더 경로 
	// 보통은 프로젝트 안에 /src/main/webapp/resources/upload 이렇게 만든다.
	private String uploadPath = "C:" + File.separator + "upload";
	
	@Inject
	private BoardService bService;
	
	@ResponseBody
	@RequestMapping (value = "/getAttach/{bno}", method = RequestMethod.GET)
	public List<String> getAttach(@PathVariable("bno") Integer bno){
		logger.info("getAttach");
		return bService.getAttach(bno);
	}
	
	
	
	
}
