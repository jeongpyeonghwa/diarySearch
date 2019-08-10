/*
 * programID : PatternMainControlloer.java
 * ����      : ���� ������ Conteroller
 * */

package com.duk.ballondor.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.duk.ballondor.common.LoggerInterceptor;

@Controller
@RequestMapping(value="/patternMain")
public class PatternMainController {
	
	protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	/* ���� */
	@RequestMapping(value="/patternMainView.do")
	public ModelAndView mainView(HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		// ���� �������� �̵�
		mav.setViewName("patternMain/patternMainView");
		logger.debug("���� ȭ�� ���� üũ : " + String.valueOf(session.getAttribute("userId")));
		
		if(session.getAttribute("userId") != null) {
			// �α��� ������ ������ �� ���� ȭ������ �޼����� �����ش�.
			
			// �������� �ѱ� key, data
			mav.addObject("msg", "success");					
		}
		
		return mav;			
	}
}
