package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardDAO;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/fmBoard/delete")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				int BOARD_NUM = Integer.parseInt(request.getParameter("BOARD_NUM"));
				String BOARD_PASS = request.getParameter("BOARD_PASS");
				BoardDAO dao  = BoardDAO.getInstance();
				dao.delBoard(BOARD_NUM,BOARD_PASS);
				
					response.setContentType("text/html; charset=UTF-8");
					
					response.sendRedirect("boardList.bo");
			
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
