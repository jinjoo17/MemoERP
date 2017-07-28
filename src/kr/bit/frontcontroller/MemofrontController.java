package kr.bit.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;


@WebServlet("*.mo")
public class MemofrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //클라이언트의 모든 요청(.mo)을 받는 프론트컨트롤러
	   //mList.mo
		//mDelete.mo
		//mUpdate.mo
		//mInsert.mo
		 request.setCharacterEncoding("euc-kr");
		//1. 무슨 요청인지 확인작업
		String command=request.getRequestURI();
		//System.out.println(command);
		String ctx=request.getContextPath();
		//System.out.println(ctx);
		
		String reqCmd=command.substring(ctx.length());
		System.out.println(reqCmd);
		//2.요청에 해당하는 POJO를 연결하는 작업(Handler mapping)
		
		
		Controller controller;
		String nextPage=null;
		HandlerMapping mp=new HandlerMapping();
		controller=mp.getController(reqCmd);
		nextPage=controller.handleRequest(request, response);
		
		
		
//		if(reqCmd.equals("/mList.mo")){//mList.mo-->MemoListController
//			 controller=new MemoListController();
//			 nextPage=controller.handleRequest(request, response);
//		}else if(reqCmd.equals("/mInsert.mo")){
//			 controller=new MemoInsertController();
//			 nextPage=controller.handleRequest(request, response);
//		}else if(reqCmd.equals("/mContent.mo")){
//			 controller=new MemoContentController();
//			 nextPage=controller.handleRequest(request, response);
//		}else if(reqCmd.equals("/mDelete.mo")){
//			 controller=new MemoDeleteController();
//			 nextPage=controller.handleRequest(request, response);
//		}else if(reqCmd.equals("/mUpdateForm.mo")){
//			 controller=new MemoUpdateFormController();
//			 nextPage=controller.handleRequest(request, response);
//		}else if(reqCmd.equals("/mUpdate.mo")){
//			 controller=new MemoUpdateController();
//			 nextPage=controller.handleRequest(request, response);
//		}
		//------------------------------------------
		//3.nextPage forward하는 작업
		if(nextPage!=null){
			if(nextPage.indexOf(":")!=-1){               //redirect:mList.mo
				response.sendRedirect(nextPage.substring(nextPage.indexOf(":")+1));
			}else{
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}

	}
}
