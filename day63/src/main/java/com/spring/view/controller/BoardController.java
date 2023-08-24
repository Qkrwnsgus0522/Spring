package com.spring.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

@Controller
public class BoardController {

	@RequestMapping(value="/board.do")
	public String board(BoardVO bVO, BoardDAO bDAO, Model model) {
		
		System.out.println("BoardController: board 로그");
		
		bDAO.update(bVO);
		
		model.addAttribute("bdata", bDAO.selectOne(bVO));
		return "board.jsp";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deletaBoard(BoardVO bVO, BoardDAO bDAO) {
		
		System.out.println("BoardController: deleteBoard 로그");
		
		if (bDAO.delete(bVO)) {
			return "redirect:main.do";			
		}
		else {
			return "board.do";
		}
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO bVO, BoardDAO bDAO) {
		
		System.out.println("BoardController: updateBoard 로그");
		
		bDAO.update(bVO);
		return "board.do";
	}
}
