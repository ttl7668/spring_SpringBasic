package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.command.BoardVO;
import com.simple.service.BoardServiceImpl;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	//화면처리
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	//폼태그요청
	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("vo") BoardVO vo) {
		System.out.println(" 컨트롤러");
		boardService.boardRegist(vo);
		return "service/boardResult";
	}
	
	@RequestMapping("/boardResult")
	public void boardResult() {
		
	}
	
	//게시판리스트요청
	@RequestMapping("/boardList")
	public String boardList(Model model) {	
		ArrayList<BoardVO> list =boardService.getList();
		model.addAttribute("list",list);
		return "service/boardList";
	}
	
}
