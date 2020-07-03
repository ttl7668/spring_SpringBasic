package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService")//scoreService으로 빈을 생성
public class ScoreServiceImpl implements ScoreService{

	@Resource(name="scoreDAO")
	private ScoreDAO scoreDAO;//멤버변수 주입
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		scoreDAO.scoreRegist(vo);
		
	}

	@Override
	public ArrayList<ScoreVO> scoreList() {
		
		//ArrayList<ScoreVO> list = scoreDAO.scoreList();
		return scoreDAO.scoreList();
	}

	@Override
	public void scoreDelete(int num) {
		scoreDAO.scoreDelete(num);
	}

}
