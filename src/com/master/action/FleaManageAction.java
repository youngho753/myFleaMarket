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
import vo.goodsDTO;

/**
 * Servlet implementation class MemberManageAction
 */
@WebServlet({ "/FleaManageAction", "/fmMaster/flea_manage.do" })
public class FleaManageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FleaManageAction() {
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
		ArrayList<goodsDTO> arr = new ArrayList<>();
		response.setContentType("text/html;charset=utf-8");
		goodsDAO dao = goodsDAO.getInstance();
		arr = dao.list();
		JSONArray jarr = new JSONArray();
		for(goodsDTO dto:arr) {
			JSONObject obj = new JSONObject();
			obj.put("num", dto.getNum());
			obj.put("userid", dto.getUserid());
			obj.put("category",dto.getCategory());
			obj.put("title", dto.getTitle());
			obj.put("price", dto.getPrice());
			jarr.add(obj);
		}
		
		PrintWriter out = response.getWriter();
		out.print(jarr.toString());
		System.out.println(jarr.toString());
	}

}
