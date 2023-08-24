package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardController 로그");
		
		BoardDAO bDAO=new BoardDAO();
		BoardVO bVO=new BoardVO();
		ModelAndView mav=new ModelAndView();
		if(bDAO.insert(bVO)){
			mav.setViewName("redirect:main.do");	
		}
		else{
			mav.setViewName("redirect:insertBoard.jsp");
		}
		return mav;
	}

}
