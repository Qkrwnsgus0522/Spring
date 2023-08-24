package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;

public class MainController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainController 로그");
		
		BoardDAO bDAO=new BoardDAO();
		request.setAttribute("datas", bDAO.selectAll(null));
				
		return "main"; // main.jsp(VIEW)로 가려고함
	}

}
