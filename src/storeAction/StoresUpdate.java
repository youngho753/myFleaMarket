package storeAction;

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

import vo.StoreDAO;
import vo.StoreDTO;
import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class GoodsUpdate
 */
@WebServlet("/fm/storeUpdate.do")
public class StoresUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoresUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		StoreDAO dao = StoreDAO.getInstance();
		StoreDTO g = dao.StoreView(num);
		request.setAttribute("goods", g);
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd =request.getRequestDispatcher("../fm/storeUpdate.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			int num =Integer.parseInt(multi.getParameter("num"));
			String summernote=multi.getParameter("summernote");
			String userid = multi.getParameter("userid");
			String title = multi.getParameter("title");
			String category = multi.getParameter("category");
			String mainpic = multi.getFilesystemName("mainpic");
			int price = Integer.parseInt(multi.getParameter("price"));
			System.out.println(summernote.length());
		
			goodsDTO goods = new goodsDTO();
			goods.setNum(num);
			goods.setUserid(userid);
			goods.setTitle(title);
			goods.setCategory(category);
			goods.setSummernote(summernote);
			goods.setMainpic(mainpic);
			goods.setPrice(price);
			goodsDAO dao = goodsDAO.getInstance();
			response.setContentType("text/html; charset=UTF-8");
			dao.goodsUpdate(goods);
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("../fm/main.jsp");
	}
}
