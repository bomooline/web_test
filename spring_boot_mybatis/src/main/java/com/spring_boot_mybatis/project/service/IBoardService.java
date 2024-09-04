package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis.project.model.BoardVO;

public interface IBoardService {	
	
	// 전체 게시글 조회 
	// public ArrayList<BoardVO> listAllBoard(); 
	public ArrayList<BoardVO> listAllBoard(HashMap<String, Integer> map); 	
	public int getBoardCount();
}








