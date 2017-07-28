package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MemoInsertFormController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nextPage="/WEB-INF/memo/memoInsert.html";
		return nextPage;
		
}
}
