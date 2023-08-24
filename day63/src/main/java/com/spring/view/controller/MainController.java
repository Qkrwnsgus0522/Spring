package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Controller
public class MainController {

	@ModelAttribute("searchMap")
	public Map<String, String> searchMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		return map;
	}
	
	@RequestMapping(value="/main.do")
//	public String main(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false)String searchCondition, @RequestParam(value="searchContent", defaultValue="", required=false)String searchContent, @ModelAttribute("mem")MemberVO mVO, BoardDAO bDAO, /* ModelAndView mav,*/ Model model) {
	public String main(@ModelAttribute("mem")MemberVO mVO, BoardVO bVO, BoardDAO bDAO, /* ModelAndView mav,*/ Model model) {
//		String searchCondition = request.getParameter("searchCondition");
		
//		System.out.println("searchCondition: " + searchCondition);
//		System.out.println("searchContent: " + searchContent);
		System.out.println("searchCondition: " + bVO.getSearchCondition());
		System.out.println("searchContent: " + bVO.getSearchContent());
		
		mVO.setMid("test");
		mVO.setMpw("1234");
		
		System.out.println("MainController 로그");
		
		// model.addAttribute("mem", mVO); // 가독성의 이유로 22번 보다는 @ModelAttribute 선호
		model.addAttribute("datas", bDAO.selectAll(null));
//		mav.addObject("datas", bDAO.selectAll(null));
//		mav.setViewName("main.jsp");
		// /WEB-INF/views/ + main + .jsp
//		return mav;
		return "main.jsp";
	}

}