package com.master.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.BoardDAO;
import vo.MemberDAO;
import vo.MemberDTO;
import vo.StoreDAO;
import vo.goodsDAO;

/**
 * Servlet implementation class MemberManageAction
 */
@WebServlet({ "/MemberManageAction", "/fmMaster/mem_manage.do" })
public class MemberManageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberDTO> arr = dao.memberList();
		response.setContentType("text/html;charset=utf-8");
		goodsDAO gdao = goodsDAO.getInstance();
		
		JSONArray jarr = new JSONArray();
		for(MemberDTO dto:arr) {
			JSONObject obj = new JSONObject();
			obj.put("userid", dto.getUserid());
			obj.put("name",dto.getName());
			obj.put("email", dto.getEmail());
			obj.put("addr", dto.getAddr());
			obj.put("income",dto.getIncome());
			obj.put("rank", dto.getRank());
			obj.put("sellcount", gdao.sellCount(dto.getUserid()));
			jarr.add(obj);
		}
		
		PrintWriter out = response.getWriter();
		out.print(jarr.toString());
		System.out.println(jarr.toString());
	}

}
