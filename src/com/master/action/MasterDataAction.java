package com.master.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardDAO;
import vo.MemberDAO;
import vo.StoreDAO;
import vo.StoreDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class MasterDataAction
 */
@WebServlet({ "/MasterDataAction", "/fmMaster/master_data.do" })
public class MasterDataAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterDataAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO m_dao = MemberDAO.getInstance();
		goodsDAO g_dao = goodsDAO.getInstance();
		StoreDAO s_dao =  StoreDAO.getInstance();
		BoardDAO b_dao = BoardDAO.getInstance();
		
		int mem_total = m_dao.memberList().size();
		System.out.println("총 회원수 : "+mem_total);
		int flea_total = g_dao.list().size();
		System.out.println("플리 판매글 갯수:"+ flea_total);
		int store_total = s_dao.list().size();
		int cart_total = g_dao.cartlist().size();
		System.out.println("장바구니 갯수 : " +cart_total);
		int qna_total = b_dao.boardCount();
		System.out.println("qna 토탈: "+qna_total);
		
		ArrayList<goodsDTO>fleaArr = new ArrayList<>();
		fleaArr = g_dao.groupBy();
		
		ArrayList<StoreDTO>storeArr = new ArrayList<>();
		storeArr = s_dao.groupBy();
		
		request.setAttribute("storeArr", storeArr);
		request.setAttribute("fleaArr", fleaArr);
		
		
		request.setAttribute("mem_total", mem_total);
		request.setAttribute("flea_total", flea_total);
		request.setAttribute("store_total", store_total);
		request.setAttribute("cart_total", cart_total);
		request.setAttribute("qna_total", qna_total);
		request.setAttribute("sign", "sign");
		RequestDispatcher rd = request.getRequestDispatcher("../fmMaster/masterPage.jsp");
		
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
