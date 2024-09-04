package com.spring_boot_mybatis.project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis.project.model.BoardVO;


public interface IBoardDAO {
	// 전체 게시판 조회 : DB에서 전체 글(VO 여러 개(ArrayList)) 찾아서 반환
	//public ArrayList<BoardVO> listAllBoard(); 	
	public ArrayList<BoardVO> listAllBoard(HashMap<String, Integer> map); 	
	public int getBoardCount();
	public int getBoardMaxNo();
}





