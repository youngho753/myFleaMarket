package goodsAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberDAO;
import vo.MemberDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class MemberView
 */
@WebServlet({ "/MemberView", "/fm/memberView.do","/fmMaster/memView.do" })
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("판매자페이지");
		String id = request.getParameter("id");
		ArrayList<goodsDTO> sell_info = new ArrayList<>();
		MemberDTO member_info = new MemberDTO();
		
		goodsDAO gdao = goodsDAO.getInstance();
		MemberDAO mdao = MemberDAO.getInstance();
		
		member_info = mdao.memberView(id); // 전화번호가져오고, income, rank, 이름 가져오자 
		sell_info = gdao.get_info(id);
		
		String naver_email =null;
		String naver_name=null;
		
		if(member_info==null) { //네이버회원이면		
			request.setAttribute("naver", "ok");
			//판매중인 글만 가져오자  만약에 네이버회원이라면 goods db에서 이메일이랑 이름까지 받아오자
			naver_name= gdao.select_string_data("username", id);
			naver_email = gdao.select_string_data("email", id);
			request.setAttribute("naver_name", naver_name);
			request.setAttribute("naver_email", naver_email);
		}
		else { //일반회원이면
			//판매중인 글만 가져오자 
			request.setAttribute("member_info", member_info);
		}
		
		
		request.setAttribute("sell_info",sell_info );
		
		
		RequestDispatcher rd = request.getRequestDispatcher("../fm/memberView.jsp");
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
