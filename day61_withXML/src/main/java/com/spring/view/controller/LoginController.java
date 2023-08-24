package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController 로그");
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		HttpSession session=request.getSession();
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("member", mVO.getMid());
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		// VR의 설정을 무시하고 main.do를 요청함
		// VR는 디폴트로 forward 방식
		return mav;
	}

}
