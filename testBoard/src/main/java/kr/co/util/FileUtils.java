package kr.co.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.BoardVO;

@Component("fileUtils")
public class FileUtils {
	
//	private static final String filePath = "C:\\mp\\file\\";
	private static final String filePath = "C:" + File.separator + "mp" + File.separator + "file";
	
	public List<Map<String , Object>> parseInsertFileInfo(BoardVO vo, 
						MultipartHttpServletRequest mpRequest) throws Exception{
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;	// 파일 확장자명
		String storedFileName = null;			// 파일 저장이름
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int bno = vo.getBno();
		
		File file = new File(filePath);
		if (file.exists() == false) {
			// 파일 이름이 없으면 만들어라
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileName;
				// 파일이름이 겹치지 않게  랜덤아이디를 붙여서 파일이름 새로이 저장한다.
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				listMap = new HashMap<String, Object>();
				listMap.put("BNO", bno);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
				
			}
		}
		
		return list;
		
	}

	// 파일이름이 겹치지 않게  랜덤아이디를 붙여서 파일이름 새로이 저장한다.
	private String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
