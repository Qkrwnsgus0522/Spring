package com.spring.view.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test1.do", method = RequestMethod.POST)
	@ResponseBody
	public String test1() {
		System.out.println("로그 : .ajax()메서드 수행함");
		return "JUN";
	}
	
	@RequestMapping(value = "/test2.do", method = RequestMethod.POST)
	@ResponseBody
	public String test2(@RequestParam("count")int count,
						@RequestParam("apple")String apple,
						@RequestParam("banana")String banana) {
		System.out.println("count : " + count);
		System.out.println("apple : " + apple);
		System.out.println("banana : " + banana);		
		count++;
		return String.valueOf(count);
	}
	
	@RequestMapping(value = "/test3.do", method = RequestMethod.POST)
	@ResponseBody
	public String test3(@RequestParam Map<String, Object> map) {
		System.out.println("count : " + map.get("count"));
		System.out.println("apple : " + map.get("apple"));
		System.out.println("banana : " + map.get("banana"));
//		Integer count=(Integer)map.get("count"); // Integer 산술연산 불가능
//		count++;
//		return count.toString();
		int count = Integer.parseInt(map.get("count").toString());
		count++;
		System.out.println(Integer.toString(count));
		return Integer.toString(count);
	}
}
