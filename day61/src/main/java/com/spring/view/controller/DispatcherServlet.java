package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri=request.getRequestURI();
    	String command=uri.substring(uri.lastIndexOf("/"));
    	System.out.println("command: "+command);
    	
    	Controller ctrl=handlerMapping.getController(command);
    	String viewName=ctrl.handleRequest(request, response);
    	// viewName이 .do를 가지고있으면 VIEW로 가는것이 아니다!
    	
    	String path=viewName;
    	if(!viewName.contains(".do")) {
    		path=viewResolver.getView(viewName);      
    	}
    	
    	response.sendRedirect(path);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
}
