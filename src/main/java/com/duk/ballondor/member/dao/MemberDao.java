/*
 * programID : MemberDao.java
 * ����   	 : �α��� DAO
 * */

package com.duk.ballondor.member.dao;

import javax.servlet.http.HttpSession;

import com.duk.ballondor.member.vo.MemberVo;

public interface MemberDao {

	// 01_01. ȸ�� �α��� üũ
	public boolean loginCheck(MemberVo vo);
	
	// 01_02. ȸ�� �α��� ����
	public MemberVo viewMember(MemberVo vo);
	
	// 02. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
}
