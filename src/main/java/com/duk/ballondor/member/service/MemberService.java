/*
 * programID : MemberService.java
 * ����      : �α��� �������̽�
 * */

package com.duk.ballondor.member.service;

import javax.servlet.http.HttpSession;

import com.duk.ballondor.member.vo.MemberVo;

public interface MemberService {

	// 01_01. ȸ�� �α��� üũ
	public boolean loginCheck(MemberVo vo, HttpSession session);
	
	// 01_02. ȸ�� �α��� ����
	public MemberVo viewMember(MemberVo vo);
	
	// 02. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);

	// 01_01. ȸ������ ID �ߺ� üũ
	public boolean signUpCheck(MemberVo vo, HttpSession session);

	// 01_02. ȸ������ insert
	public void insertMember(MemberVo vo);
}
