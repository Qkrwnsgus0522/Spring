package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;

public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainController 로그");
		
		BoardDAO bDAO=new BoardDAO();
		request.setAttribute("datas", bDAO.selectAll(null));
				
		ModelAndView mav=new ModelAndView();
		mav.setViewName("main");
		// /WEB-INF/views/ + main + .jsp
		return mav;
	}

}
