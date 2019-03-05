package util;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URLEncoder;
 import java.net.URL;
import java.net.HttpURLConnection;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;

/**
 * Servlet implementation class NaverLoginAction
 */
@WebServlet({ "/NaverLoginAction", "/fmMember/naver.do" })
public class NaverLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String clientId = "VfMEP3DuTDKW1yGcrao_";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "5HO5lbm2AA";//애플리케이션 클라이언트 시크릿값";

	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8888/myFleaMarket/fmMember/naver.do", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;

	    System.out.println("apiURL="+apiURL);
	    StringBuffer res = null;
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) {
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	    	  System.out.println(res.toString());
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }

	    System.out.println("요기서 토큰파싱합시다:" + res.toString());
	    String origin_str = res.toString(); //우루루  다 있는거 이중에서 토큰 파싱하자
	    
	

	    
	    String token="";
	    JSONParser jsonparser = new JSONParser();
	    try {
			JSONObject jsonObject = (JSONObject)jsonparser.parse(origin_str);
			System.out.println(jsonObject.get("access_token"));
			token = jsonObject.get("access_token").toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.setAttribute("token", token);
	    RequestDispatcher rd = request.getRequestDispatcher("parse.do");
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
