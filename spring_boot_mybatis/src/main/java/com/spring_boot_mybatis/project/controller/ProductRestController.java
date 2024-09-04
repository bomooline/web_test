package com.spring_boot_mybatis.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring_boot_mybatis.project.model.ProductVO;
import com.spring_boot_mybatis.project.service.OCRService;
import com.spring_boot_mybatis.project.service.ProductService;


@RestController
public class ProductRestController {
	@Autowired
	ProductService prdService;
	
	@Autowired
	private OCRService ocrService;
	
	//@ResponseBody 없음
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param) {
		ArrayList<ProductVO> prdList = prdService.productSearch(param);		
		return prdList;
	}
	
	// 서버 테스트용 
	@RequestMapping("/ocr")
	public String ocr(@RequestParam("uploadFile") MultipartFile file){	
		String result = "";
		try {			
			//String uploadPath = "C:/springWorkspace/upload/"; // 로컬 경로
			String uploadPath = "/usr/local/project/upload/"; // 서버 경로
			
			String originalFileName = file.getOriginalFilename();
			String filePathName = uploadPath + originalFileName;
			System.out.println("1 : " + filePathName);
			File newFile = new File(filePathName);
			
			file.transferTo(newFile);
			
			result = ocrService.clovaOCRService(filePathName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
