package storeAction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.StoreDAO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class GoodsDelete
 */
@WebServlet({"/fm/storeDelete.do","/fmMaster/store_delete.do"})
public class StoreDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		StoreDAO dao = StoreDAO.getInstance();
		dao.StoreDelete(num);
		response.sendRedirect("../fm/store.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("스토어삭제도착");
		StoreDAO dao = StoreDAO.getInstance();
		System.out.println("다오생성완료");
		int num = Integer.parseInt(request.getParameter("store_num"));
		System.out.println(num);
		PrintWriter out = response.getWriter();
		boolean check =dao.StoreCheck(num); 
		if(!check) {
			out.print("no");
		}
		else {
			dao.StoreDelete(num);
			out.println("ok");
		}
	}

}
