package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberDAO;
import vo.MemberDTO;

/**
 * Servlet implementation class MemberUpdateAction
 */
@WebServlet({"/MemberUpdateAction","/fmMember/infoupdate.do"})
public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		
		MemberDAO dao =MemberDAO.getInstance();
		
		MemberDTO dto = new MemberDTO();
		dto.setZipcode(zipcode);
		dto.setAddr(addr);
		dto.setPhone(phone);
		dto.setUserid(id);
		
		dao.memberUpdate(dto);
		
		response.sendRedirect("myPage.do?id="+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
