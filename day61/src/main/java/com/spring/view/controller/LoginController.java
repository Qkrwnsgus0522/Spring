package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController 로그");
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		HttpSession session=request.getSession();
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("member", mVO.getMid());
		}
		
		return "main.do"; // .do로 끝나므로 Controller로 가려고하는것
	}

}
