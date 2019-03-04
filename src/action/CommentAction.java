package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardDAO;
import vo.CommentVO;

/**
 * Servlet implementation class CommentAction
 */
@WebServlet("/fmBoard/comment")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentVO c = new CommentVO();
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		String msg= request.getParameter("msg");
		c.setBnum(bnum);
		c.setMsg(msg);
		BoardDAO dao = new BoardDAO();
		dao.commentInsert(c);
		
		request.setAttribute("bnum", bnum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("commentList");
		dispatcher.forward(request, response);
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	}	
}
