package storeAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.StoreDAO;
import vo.StoreDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class GoodsView
 */
@WebServlet("/fm/storeView.do")
public class StoreView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreView() {
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
		StoreDTO g = dao.StoreView(num);
		System.out.println("나오세요 좀 예?");
		System.out.println(g.getNum());
		request.setAttribute("goods", g);
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd =request.getRequestDispatcher("storeViewPage.jsp");
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
