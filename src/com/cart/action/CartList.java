package com.cart.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.StoreDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class CartList
 */
@WebServlet({ "/CartList", "/fm/cartList.do" })
public class CartList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("나오라고 시발");
		String id = request.getParameter("id");
		System.out.println("맞나:" + id);
		
		goodsDAO dao =goodsDAO.getInstance();
		
		ArrayList<StoreDTO> arr = dao.cartlist(id);

		
		if(arr.size() ==0) {
			request.setAttribute("lists", "no");
		}
		else {
			request.setAttribute("lists", arr);
		}
		RequestDispatcher rd = request.getRequestDispatcher("../fm/cart.jsp");
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
