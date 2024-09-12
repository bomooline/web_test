package com.spring_boot_mybatis.project.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring_boot_mybatis.project.service.FishService;

@Controller
public class FishController {
	@Autowired
	FishService fishService;
	
	@RequestMapping("/fishDetectForm") 
	public String fishDetectForm() {
		//fishService.getFishName();
		return "fish_detect"; // index.jsp 파일의 이름 반환
	}
	
	@ResponseBody
	@RequestMapping("/fishDetect") 
	public String fishDetect(@RequestParam("uploadFile") MultipartFile file) {
		
		String result = "";
		try {			
			String uploadPath = "D:/springWorkspace/ai/upload/";
			
			String originalFileName = file.getOriginalFilename();
			String filePathName = uploadPath + originalFileName;
			System.out.println("1 : " + filePathName);
			File newFile = new File(filePathName);
			
			file.transferTo(newFile);
			
			result = fishService.getFishName(filePathName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
