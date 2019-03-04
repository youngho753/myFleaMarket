package goodsAction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class GoodsDelete
 */
@WebServlet({"/fm/goodsDelete.do","/fmMaster/goods_delete.do"})
public class GoodsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		goodsDAO dao = goodsDAO.getInstance();
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		dao.goodsDelete(num);
		response.sendRedirect("../fm/shop.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("도착");
		goodsDAO dao = goodsDAO.getInstance();
		System.out.println("다오생성완료");
		int num = Integer.parseInt(request.getParameter("goods_num"));
		System.out.println(num);
		PrintWriter out = response.getWriter();
		boolean check =dao.goodsCheck(num); 
		if(!check) {
			out.print("no");
		}
		else {
			dao.goodsDelete(num);
			out.println("ok");
		}
	}

}
