package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
@WebServlet({"/fm/msgList.do","/fmMSG/msgList.do"})
public class msgListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public msgListAction() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<String> arr = new ArrayList<>();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		HashMap<String,String> map= new HashMap<>();
		MSGDAO dao = MSGDAO.getInstance();
		arr= dao.msgcheck(id);
		for(int i =0;i<arr.size();i++) {
			String userid = arr.get(i);
			System.out.println(userid);
			String a = dao.readcheck(userid,id);

			map.put(userid, a);
		}
		request.setAttribute("lists",map);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../fmMSG/msgList.jsp");
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
