package action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.Security_SHA256;
import vo.BoardDAO;
import vo.BoardVO;
import vo.MemberDAO;
import vo.MemberDTO;


@WebServlet("/fmBoard/insert.do")
public class WriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WriteAction() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	

		BoardVO bv = new BoardVO();
		bv.setBOARD_NAME(request.getParameter("board_name"));
		System.out.println(request.getParameter("board_name"));
		bv.setBOARD_PASS(request.getParameter("board_pass"));
		System.out.println(request.getParameter("board_pass"));
		bv.setBOARD_SUBJECT(request.getParameter("board_subject"));
		System.out.println(request.getParameter("board_subject"));
		bv.setBOARD_CONTENT(request.getParameter("board_content"));
		System.out.println(request.getParameter("board_content"));
		bv.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("re_lev")));
		System.out.println(Integer.parseInt(request.getParameter("re_lev")));
		bv.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("re_seq")));
		System.out.println(Integer.parseInt(request.getParameter("re_seq")));
		bv.setBOARD_RE_REF(Integer.parseInt(request.getParameter("ref")));
		bv.setBOARD_NUM(Integer.parseInt(request.getParameter("num")));
		bv.setBOARD_OPEN(request.getParameter("board_open"));
	
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardInsert(bv);
		response.sendRedirect("boardList.bo");
		
	    

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
