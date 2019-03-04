package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Security_SHA256;
import vo.MemberDAO;
import vo.MemberDTO;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet({ "/JoinAction", "/fmMember/join.do" })
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		System.out.println(request.getParameter("password"));
		util.Security_SHA256 security = new Security_SHA256();
		String pwd = security.encriptSHA256((String)request.getParameter("password"));
		System.out.println(pwd);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String zipcode= request.getParameter("zipcode");
		String addr = request.getParameter("addr");
	  
		MemberDTO mb = new MemberDTO();
	    mb.setName(name);
	    mb.setUserid(userid);
	    mb.setPassword(pwd);
	    mb.setPhone(phone);
	    mb.setEmail(email);
	    mb.setZipcode(zipcode);
	    mb.setAddr(addr);
	    
	    
	    dao.memberInsert(mb);
	    request.setAttribute("sign", "sign");
	    response.setContentType("text/html; charset=UTF-8");
	    RequestDispatcher rd =request.getRequestDispatcher("../fm/main.jsp");
	    rd.forward(request, response);
	    


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
