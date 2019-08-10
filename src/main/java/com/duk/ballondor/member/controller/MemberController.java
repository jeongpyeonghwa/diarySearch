/*
 * programID : MemeberControlloer.java
 * ����      : �α��� Conteroller
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
	
	// 01. �α��� ȭ��
	@RequestMapping(value="/login.do")
	public String login() {
		return "member/login";
	}
	
	// 02. �α��� ó��
	// - ���̵�� ��й�ȣ�� DB�� ��ȿ�ϸ� TRUE�� ���� �޾� �α��� ����.
	// - ���񽺿��� ���� �� ���ǿ� ���̵�� �̸� ���.
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVo vo, HttpSession session) {
		
		logger.debug("getUserId: " + vo.getUserId());
		logger.debug("getUserPw: " + vo.getUserName());
		
		boolean result = memberService.loginCheck(vo, session);
		
		logger.debug("�α��� ��� : " + String.valueOf(result));
		
		ModelAndView mav = new ModelAndView();
		
		// �α��� ����
		if(result == true) {
			
			// ���� �������� �̵�
			mav.setViewName("patternMain/patternMainView");
			// �������� �ѱ� key, data
			mav.addObject("msg", "success");
		// �α��� ����
		} else {
			
			// �α��� �������� �̵�
			mav.setViewName("member/login");
			mav.addObject("msg", "fialure");			
		}
		
		return mav;
	}
	
	// 03. �α׾ƿ� ó��
	@RequestMapping(value="logout.do")
	public ModelAndView logout(HttpSession session) {
		
		memberService.logout(session);
		
		ModelAndView mav = new ModelAndView();
		
		// ���� �������� �̵�
		mav.setViewName("patternMain/patternMainView");
		/*mav.addObject("msg", "logout");*/
		
		return mav;
	}
}
