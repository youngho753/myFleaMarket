package storeAction;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import vo.StoreDAO;
import vo.StoreDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/fm/storeUploadAction.re")
public class StoreInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = "upload";
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(uploadPath);
		int size = 50 * 1024 * 1024;  
	 	try{
			MultipartRequest multi = new MultipartRequest(
						request,uploadFilePath,size,encType,
						new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 
			
			String username=multi.getParameter("name");
			String email=multi.getParameter("email");
			String summernote=multi.getParameter("summernote");
			String userid = multi.getParameter("userid");
			String title = multi.getParameter("title");
			String category = multi.getParameter("category");
			String mainpic = multi.getFilesystemName("mainpic");
			int price = Integer.parseInt(multi.getParameter("price"));
			
			StoreDTO goods = new StoreDTO();
			goods.setUserid(userid);
			goods.setTitle(title);
			goods.setCategory(category);
			goods.setSummernote(summernote);
			goods.setMainpic(mainpic);
			goods.setPrice(price);
			StoreDAO dao = StoreDAO.getInstance();
			response.setContentType("text/html; charset=UTF-8");
			dao.StoreInsert(goods);
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("../fm/main.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
