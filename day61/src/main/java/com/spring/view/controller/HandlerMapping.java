package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	// FrontController에서 사용되는 factory 클래스의 이름
	// 팩토리 패턴을 사용하기때문에 싱글톤이 유지됨
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String command) {
		Controller ctrl=mappings.get(command);
		return ctrl;
	}	
}
