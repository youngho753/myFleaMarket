package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import vo.BoardDAO;
import vo.BoardVO;


@WebServlet("/fmBoard/reply")
public class ReplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyAction() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String realFolder="";
		String saveFolder="/boardUpload";
		int fileSize=5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,realFolder,fileSize,"UTF-8",new DefaultFileRenamePolicy());
		BoardVO bv = new BoardVO();
		int num = Integer.parseInt(multi.getParameter("num"));
		bv.setBOARD_NAME(multi.getParameter("board_name"));
		bv.setBOARD_PASS(multi.getParameter("board_pass"));
		bv.setBOARD_SUBJECT(multi.getParameter("board_subject"));
		bv.setBOARD_CONTENT(multi.getParameter("board_content"));
		bv.setBOARD_RE_LEV(Integer.parseInt(multi.getParameter("re_lev")));
		bv.setBOARD_RE_SEQ(Integer.parseInt(multi.getParameter("re_seq")));
		bv.setBOARD_RE_REF(Integer.parseInt(multi.getParameter("ref")));
		bv.setBOARD_NUM(Integer.parseInt(multi.getParameter("num")));
		String filename = multi.getFilesystemName("board_file");
		String orgName = multi.getOriginalFileName("board_file");
//		bv.setBOARD_FILE(orgName);
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardReply(bv,num);
		response.sendRedirect("boardList.bo");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
