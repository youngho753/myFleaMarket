package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class MessageViewAction
 */
@WebServlet({"/fm/msgView.do","/fmMSG/msgView.do"})
public class MessageViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");//내아이디
		String userid=request.getParameter("userid");//메세지 하는 대상
		
		MSGDAO dao = MSGDAO.getInstance();
	/*	dao.msgUpdate(userid, id);*/
		ArrayList <MSGVO> arr = dao.msgList(userid,id);

		request.setAttribute("userid",userid);
		request.setAttribute("lists",arr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../fmMSG/msgView.jsp");
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
