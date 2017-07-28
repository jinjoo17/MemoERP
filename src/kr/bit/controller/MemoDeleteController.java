package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoMybatisDAO;



public class MemoDeleteController implements Controller  {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num=Integer.parseInt(request.getParameter("mnum"));
		
		MemoMybatisDAO dao=new MemoMybatisDAO();
		int cnt=dao.memoDelete(num);
		String nextPage=null;
		if(cnt>0){
			//response.sendRedirect("mList.mo");
			nextPage="/WEB-INF/redirect:mList.mo";
		}
		return nextPage;
		}
		
		
		
	}


