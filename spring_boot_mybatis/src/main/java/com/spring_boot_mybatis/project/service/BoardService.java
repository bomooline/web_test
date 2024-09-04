package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.project.dao.IBoardDAO;
import com.spring_boot_mybatis.project.model.BoardVO;

@Service
public class BoardService implements IBoardService {
	@Autowired
	@Qualifier("IBoardDAO")
	IBoardDAO dao;

	@Override
	public ArrayList<BoardVO> listAllBoard(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.listAllBoard(map);
	}

	@Override
	public int getBoardCount() {
		System.out.println(dao.getBoardMaxNo());
		return dao.getBoardCount();
	}
}
