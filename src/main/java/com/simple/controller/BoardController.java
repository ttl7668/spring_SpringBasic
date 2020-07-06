package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//게시글 등록
	@RequestMapping("/boardForm")
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		return "service/boardResult";
	}
			
	//게시판리스트화면 처리
	@RequestMapping("/boardList")
	public String boardList(Model model) {	
		
		ArrayList<BoardVO> list =boardService.getList();
		model.addAttribute("list",list);
		return "service/boardList";
	}
	
	//게시판삭제요청
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num,RedirectAttributes RA) {

		boardService.boardDelete(num);
		RA.addAttribute("num",num);
		return "redirect:/service/boardList";
	}
	
}
