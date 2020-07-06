package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void boardRegist(BoardVO vo) {
		System.out.println("서비스");
		boardDAO.boardRegist(vo);
		
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return boardDAO.getList() ;
	}

	@Override
	public void boardDelete(int num) {
		
		boardDAO.boardDelete(num);
		
	}

}
