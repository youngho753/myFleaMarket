package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MSGDAO;
import vo.MSGVO;

/**
 * Servlet implementation class msgReadCheckAction
 */
@WebServlet("/fm/msgReadCheckAction")
public class msgReadCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	      
	      String id = request.getParameter("id");
	      MSGVO m = new MSGVO();
	      m.setUserid(id);
	      m.setSendid(request.getParameter("userid"));
	      m.setContent(request.getParameter("content"));
	      System.out.println("ggg" +id);
	      System.out.println(request.getParameter("userid"));
	      MSGDAO dao = MSGDAO.getInstance();
	      dao.msgInsert(m);/*
	      PrintWriter out=response.getWriter();
	      out.println("<script>history.back(); </script>");
	*/
	      request.setAttribute("userid",request.getParameter("userid"));
	      request.setAttribute("content",request.getParameter("content"));
	      request.setAttribute("id", id);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("msgView.do");
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
