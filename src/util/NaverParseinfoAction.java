package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Servlet implementation class NaverParseinfoAction
 */
@WebServlet({ "/NaverParseinfoAction", "/fmMember/parse.do" })
public class NaverParseinfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverParseinfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String token = (String) request.getAttribute("token");
		// String token = "AAAAOorspXpmQSF2PZG3hZJuuhQAdLUGZNxYWyAtHmy5LeGnDyEpL3nHMFk2YKgfZGHQ8kY0xkpFYTNOINlEO8+hIzI=";// 네이버 로그인 접근 토큰;
	        String header = "Bearer " + token; // Bearer 다음에 공백 추가
	       String email = "";
	       String name="";
	       String id="";
	        try {
	            String apiURL = "https://openapi.naver.com/v1/nid/me";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Authorization", header);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer resp = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                resp.append(inputLine);
	            }
	            br.close();
	            
	            String origin_str = resp.toString();
	            System.out.println("내가원하는거 : "+ origin_str);
	            
	            JSONParser jsonparser = new JSONParser();
	            JSONObject jsonObject = (JSONObject)jsonparser.parse(origin_str);
	            JSONObject responseObject = (JSONObject)jsonObject.get("response");

				
				 email = (String) responseObject.get("email");
				name = (String) responseObject.get("name");
				 id = (String) responseObject.get("id");
				
				
				
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("id",id);
		session.setAttribute("email", email);
		request.setAttribute("sign", "sign");
		RequestDispatcher rd = request.getRequestDispatcher("../fm/main.jsp");
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
