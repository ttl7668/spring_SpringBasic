package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request")
public class ExamController {
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(ReqVO vo) {
		if(vo.getId().equals("abc123")&&vo.getPw().equals("xxx123")) {
			return "request/req_quiz01_ok";
			
		}else {
			return "request/req_quiz01_no";
		}
	}
}
