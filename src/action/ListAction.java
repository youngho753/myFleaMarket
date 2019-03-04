package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class ListAction
 */
@WebServlet({"/fmBoard/boardList.bo","/fm/boardList.bo"})
public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = BoardDAO.getInstance();
	
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5;
		int startRow = (currentPage-1)*pageSize+1; //2page -> 6����ۺ���
		int endRow = currentPage*pageSize;
		int count = dao.boardCount();
		
		ArrayList<BoardVO> arr = dao.boardList(startRow,endRow);
		ArrayList<BoardVO> arrn=dao.noticeList();
		
		//����������
		int totpage = count/pageSize+(count%pageSize==0?0:1);
		int blockpage =3; //[����] 456 [����]
		int startpage=((currentPage-1)/blockpage)*blockpage+1;
		int endpage=startpage+blockpage-1;
		
		if(endpage > totpage) endpage=totpage;
		
		request.setAttribute("totpage", totpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("blockpage", blockpage);
		
		int number=count-(currentPage-1)*pageSize;
		request.setAttribute("number",number);
		request.setAttribute("lists", arr);
		request.setAttribute("noticelists", arrn);
		request.setAttribute("count", count);
		request.setAttribute("sign","sign");
		RequestDispatcher dispatcher = request.getRequestDispatcher("../fmBoard/boardList.jsp");
		dispatcher.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
