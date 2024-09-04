package com.spring_boot_mybatis.project.controller;
// https://milku.tistory.com/68
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_boot_mybatis.project.model.BoardPagingVO;
import com.spring_boot_mybatis.project.model.BoardVO;
import com.spring_boot_mybatis.project.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bordService;

	@RequestMapping("/board/listAllBoard")
	public String  listAllProduct(@RequestParam(required=false, defaultValue="1") int pageNo,
				Model model) {
		
		BoardPagingVO pageVo = new BoardPagingVO(pageNo, 10, bordService.getBoardCount());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", (pageVo.getStartNo()-1));
		map.put("endNo", pageVo.getEndNo());
		
		//System.out.println(pageVo.getStartNo());
		//System.out.println(pageVo.getEndNo());
		
		ArrayList<BoardVO> boardList = bordService.listAllBoard(map);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageVo", pageVo);
		
		//System.out.println(boardList.get(0).getbNo());
		return "board/boardListView";
	}
}
