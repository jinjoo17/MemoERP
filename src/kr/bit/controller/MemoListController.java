package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoMybatisDAO;
import kr.bit.model.MemoVO;



public class MemoListController implements Controller {//POJO
	public String handleRequest(HttpServletRequest request, 
			                  HttpServletResponse response) 
			               throws ServletException, IOException {
		
		MemoMybatisDAO dao=new MemoMybatisDAO();
		List<MemoVO> list=dao.memoList();
		request.setAttribute("list", list);
		//memoList.jsp--> forward
		//RequestDispatcher rd=request.getRequestDispatcher("memo/memoList.jsp");
		//rd.forward(request, response);
		String nextPage="/WEB-INF/memo/memoList.jsp";//forward
		return nextPage;
		
	}

}
