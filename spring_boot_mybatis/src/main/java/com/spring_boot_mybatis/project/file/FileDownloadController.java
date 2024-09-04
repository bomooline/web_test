package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileDownloadController {
	// 다운로드 받을 파일 리스트 출력 : upload 폴더의 모든 파일 목록 출력
	@RequestMapping("/fileDownloadList")
	public String fileDownloadList(Model model) {
		// "C:/springWorkspace/upload/" 폴더에 있는 전체 파일 목록 가져오기
		File path = new File("C:/springWorkspace/upload");
		String[] fileList = path.list();
		
		model.addAttribute("fileList", fileList);
		
		return "upload/fileDownloadListView";
	}
	
	// 선택한 파일을 다운로드 폴더에 다운로드 함
	@RequestMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file,
												  HttpServletResponse response) throws IOException {
		// 1. 파일 객체 생성
		File f = new File("C:/springWorkspace/upload/", file);
		
		// 한글 파일명 인코딩 필요 (한글 이름 안 깨지고 잘 다운로드 되지만, 콘솔창에 유니코드 예외 발생)
		String encodedFileName = new String(file.getBytes("UTF-8"), "ISO-8859-1");
		
		// 2. file 다운로드 설정 : response 객체를 통해서 
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition",  
					"attatchment;filename=\"" + encodedFileName + "\"");
		
		// 3. 파일 다운로드 : FileCopyUtils.copy()
		// 파일 입력 스트림 객체 생성 : 다운로드 할 파일
		FileInputStream fis = new FileInputStream(f);
		// 출력 스트림 객체 생성 : response 객체를 통해서 응답 (서버로부터 클라이어트로 파일 다운로드)
		OutputStream os = response.getOutputStream();
		// 복사
		FileCopyUtils.copy(fis, os);
		// 다운로드 폴더로 파일 다운로드 됨
		
	}
}
