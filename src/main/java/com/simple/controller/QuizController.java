package com.simple.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.ReqVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping(value="/sendBirth",method=RequestMethod.POST)
	public String sendBirth(@ModelAttribute("birth") Quiz01VO vo) {
		
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email) {
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value="/join2",method=RequestMethod.POST)
	public String join2(@ModelAttribute("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes RA
						) {
		
		if(id.equals("")) {
			
			RA.addFlashAttribute("msg","아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
			
		}else if(!pw.equals(pw_check)) {
			RA.addFlashAttribute("msg","비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
			
		}else {
			return "quiz/quiz03_ok";
		}
		
	}
}
