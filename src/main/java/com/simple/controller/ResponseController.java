package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	//화면처리
	@RequestMapping("/res_ex01")
	public String res_ex01() {
		return "response/res_ex01";
	}

	//화면처리
	//model전달자-메서드의 매개변수로 model을 선언 addAttribute("키","값")을 전달
	//가장 좋은방법
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {

		model.addAttribute("servertime",new Date());
		model.addAttribute("name","홍길동");
		return "response/res_ex02";
	}

	//ModelAndView방식
	//model에 대한 정보와 화면에 대한 정보를 따로 지정해서 보내는 방법
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("servertime",new Date()); //데이터저장
		mv.addObject("name","이순신");

		mv.setViewName("response/res_ex03");//화면 저장
		return mv;
	}

	//ModelAttribute어노테이션 방법
	//req와 model이 합쳐진 형태
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String id) {
		System.out.println("넘어온값"+id);
		return "response/res_ex04";
	}

	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		return "response/res_ex05";
	}

	//--------------------redirect와 redirectAttribute--------------


	//화면처리
	@RequestMapping(value="/res_redirect_login")
	public String res_redirect() {
		System.out.println("탓어");
		return "response/res_redirect_login";
	}

	//로그인처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes RA
			) {
 
		if(id.equals(pw)) {//로그인성공
			return "response/res_redirect_ok";//성공페이지
		}else { //로그인실패->다시 로그인화면으로 이동
			
			//"redirect:/절대경로" - 다시 컨트롤러를 타게함. 이때 화면에 값을 전달하고 싶다면
			//RedriectAttribute 객체의 addFlashAttribute를 이용하면 됩니다.
			//리다이렉트시 모델은 전달 할 수 없습니다.
			RA.addFlashAttribute("msg","아이디 비밀번호를 확인하세요.");
			return "redirect:/response/res_redirect_login";
		}
	}
	
	@RequestMapping(value="/res_quiz01")
	public String res_quiz01() {
		
		return "response/res_quiz01";
	}
	
	@RequestMapping(value="res_login",method=RequestMethod.POST)
	public String res_login(@ModelAttribute("login") ReqVO vo) {
		if(vo.getId().equals("kim12")&&vo.getPw().equals("1234")) {
			return "response/res_quiz02";
		}else {
			System.out.println(vo.getId());
			return "response/res_quiz03";
		}
	}
}
