package goodsAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class FashionList
 */
@WebServlet("/fm/CaList.do")
public class CategoryList extends HttpServlet {
	String word;
	String field;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		if(request.getParameter("word")!=null){
			word=request.getParameter("word");
			field=request.getParameter("field");
		}
		else {
			word="";
			field="";
		}
		System.out.println(category);
		System.out.println(pageNum);
		System.out.println(word);
		System.out.println(field);
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 6;
		int startRow = (currentPage-1)*pageSize+1; //2page -> 6번댓글부터
		int endRow = currentPage*pageSize;
		
		goodsDAO dao = goodsDAO.getInstance();
		ArrayList<goodsDTO> arr = dao.goodsList(field,word,startRow,endRow,category);
		int count = dao.goodsCount(field,word,category);
		//총페이지수
		int totpage = count/pageSize+(count%pageSize==0?0:1);
		int blockpage =3; //[이전] 456 [다음]
		int startpage=((currentPage-1)/blockpage)*blockpage+1;
		int endpage=startpage+blockpage-1;
		
		if(endpage > totpage) endpage=totpage;
		
		int number=count-(currentPage-1)*pageSize;
		request.setAttribute("totpage", totpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("blockpage", blockpage);
		request.setAttribute("number", number);
		request.setAttribute("lists", arr);
		request.setAttribute("count", count);
		request.setAttribute("lists", arr);
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		
		if(category.equals("fashion")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/fashionPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("living")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/livingPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("hobby")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/hobbyPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("food")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/foodPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("pet")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/petPage.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
