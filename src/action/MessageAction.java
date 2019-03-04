package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MSGDAO;
import vo.MSGVO;

/**
 * Servlet implementation class MessageAction
 */
@WebServlet("/fm/message.do")
public class MessageAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAction() {
       
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
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