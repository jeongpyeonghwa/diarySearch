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
		
		vo.setUserId(vo.getUserId().trim());
		vo.setUserPw(vo.getUserPw().trim());
		
		logger.debug("getUserId: " + vo.getUserId());
		logger.debug("getUserPw: " + vo.getUserPw());
		
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
			mav.addObject("msg", "failure");			
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
	
	// 01. ȸ������ ȭ��
	@RequestMapping(value="/signUp.do")
	public String signUp() {
		return "member/signUp";
	}	
	
	// 02. ȸ������ ó��
	// - ���̵� DB�� ��ȿ�ϸ� TRUE�� ���� �޾� ȸ������ ����
	// - ���ԿϷ� �� �α��� ȭ������ �̵�
	@RequestMapping(value="/signUpCheck.do")
	public ModelAndView signUpCheck(@ModelAttribute MemberVo vo, HttpSession session) {
		
		vo.setUserId(vo.getUserId().trim());
		vo.setUserName(vo.getUserName().trim());
		vo.setUserPw(vo.getUserPw().trim());
		
		logger.debug("getUserId: " + vo.getUserId());
		logger.debug("getUserName: " + vo.getUserName());
		logger.debug("getUserPw: " + vo.getUserPw());
		
		boolean result = memberService.signUpCheck(vo, session);
		
		logger.debug("ȸ������ ��� : " + String.valueOf(result));
		
		ModelAndView mav = new ModelAndView();
		
		// ȸ������ ����
		if(result == false) {
			
			// ȸ������ �������� �̵�
			mav.setViewName("member/signUp");
			// �������� �ѱ� key, data
			mav.addObject("msg", "failure");
		// ȸ������ ����
		} else {
			
			// �α��� �������� �̵�
			mav.setViewName("member/login");				
		}
		
		return mav;
	}	
}
