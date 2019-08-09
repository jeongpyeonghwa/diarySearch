/*
 * programID : MemeberControlloer.java
 * 내용      : 로그인 Conteroller
 * */

package com.duk.ballondor.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.duk.ballondor.common.LoggerInterceptor;
import com.duk.ballondor.member.service.MemberService;
import com.duk.ballondor.member.vo.MemberVo;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Inject
	MemberService memberService;
	
	// 01. 로그인 화면
	@RequestMapping(value="/login.do")
	public String login() {
		return "member/login";
	}
	
	// 02. 로그인 처리
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVo vo, HttpSession session) {
		
		boolean result = memberService.loginCheck(vo, session);
		
		ModelAndView mav = new ModelAndView();
		
		// 로그인 성공
		if(result == true) {
			
			// 메인 페이지로 이동
			mav.setViewName("patternMain/patternMainView");
			// 메인으로 넘길 key, data
			mav.addObject("msg", "success");
		// 로그인 실패
		} else {
			
			// 로그인 페이지로 이동
			mav.setViewName("member/login");
			mav.addObject("msg", "fialure");
		}
		
		return mav;
	}
	
	// 03. 로그아웃 처리
	@RequestMapping(value="logout.do")
	public ModelAndView logout(HttpSession session) {
		
		memberService.logout(session);
		
		ModelAndView mav = new ModelAndView();
		
		// 로그인 페이지로 이동
		mav.setViewName("member/login");
		mav.addObject("msg", "logout");
		
		return mav;
	}
}
