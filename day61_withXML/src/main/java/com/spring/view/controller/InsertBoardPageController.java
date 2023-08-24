package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertBoardPageController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardPageController 로그");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:insertBoard.jsp");
		return mav;
	}

}
