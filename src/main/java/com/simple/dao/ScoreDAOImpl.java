package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;


@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO{
	
	//DB라고 가정
	private ArrayList<ScoreVO> DB = new ArrayList<>();

	@Override
	public void scoreRegist(ScoreVO vo) {
		DB.add(vo);
		System.out.println(DB.toString());
		System.out.println("scoreDAO영역");
		
	}

	@Override
	public ArrayList<ScoreVO> scoreList() {
		
		return DB;
	}

	@Override
	public void scoreDelete(int num) {
		DB.remove(num);
		
	}


}
