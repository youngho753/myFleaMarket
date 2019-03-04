package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Security_SHA256;
import vo.MemberDAO;
import vo.MemberDTO;


/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/fmMember/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userid= request.getParameter("userid");
		String pwd=request.getParameter("password");
		

		MemberDAO dao = MemberDAO.getInstance();
		
		Security_SHA256 sha256 = new Security_SHA256();
		System.out.println("입력한 pwd : "  +pwd);
		String password = sha256.encriptSHA256(pwd);
		System.out.println("넘긴값" + userid + password);
		
		int check=dao.userCheck(userid,password);
		System.out.println("결과:" +  check);
		
		String name = dao.getName(userid);
		
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(check==1) {
			session.setAttribute("id",userid);
			session.setAttribute("name", name);
			request.setAttribute("sign", "sign");
			RequestDispatcher rd = request.getRequestDispatcher("../fm/main.jsp");
			rd.forward(request, response);
		}else if(check==-1) {
			out.println("<script> alert('비밀번호가 맞지 않습니다.'); location.href='naverlogin.jsp'; </script>");
			out.flush();
		}else {
			out.println("<script> alert('없는아이디입니다.'); location.href='naverlogin.jsp'; </script>");
			out.flush();
		}	
	}
}


