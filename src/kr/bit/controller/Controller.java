package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//      ?
	public String handleRequest(HttpServletRequest request,
			                  HttpServletResponse response) 
			                  throws ServletException, IOException ;
		   //클라이언트의 모든 요청(.mo)을 받는 프론트컨트롤러
}
