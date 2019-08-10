/*
 * programID : MemeberServiceImpl.java
 * ����      : �α��� ���� ����
 * */

package com.duk.ballondor.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.duk.ballondor.common.LoggerInterceptor;
import com.duk.ballondor.member.dao.MemberDao;
import com.duk.ballondor.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Inject
	MemberDao memberDao;
	
	// 01_01. ȸ�� �α��� üũ
	@Override
	public boolean loginCheck(MemberVo vo, HttpSession session) {
		
		boolean result = memberDao.loginCheck(vo);
		
		// true�̸� ���� ���
		if(result) {
			
			MemberVo vo2 = viewMember(vo);
			// ���� ���� ���
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
			
			logger.debug("session userId : " + vo2.getUserId());
			logger.debug("session userName : " + vo2.getUserName());
		}
		return result;
	}
	
	// 01_02. ȸ�� �α��� ����
	@Override
	public MemberVo viewMember(MemberVo vo) {
		
		return memberDao.viewMember(vo);
	}
	
	// 02. ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		
		// ���� ���� �ʱ�ȭ
		session.invalidate();
	}
}
