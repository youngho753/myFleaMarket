package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberDAO;

/**
 * Servlet implementation class PWDsearchAction
 */
@WebServlet({ "/PWDsearchAction", "/fmMember/pwd_search.do" })
public class PWDsearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PWDsearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("비번찾기 ");

		String userid = request.getParameter("id");
		String email = request.getParameter("email");
		
		System.out.println(userid+email);
		
		PrintWriter out = response.getWriter(); 
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.getPWD(userid, email);
		
		//임시비밀번호 생성
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < 7; i++) {
			int n = (int) (Math.random() * 10);
			str.append(n);
		}
		String num = str.toString();
				
		if(result == 1) // 일단은 id email이 정확할때 
		{
			try {
				dao.updatePWD(userid,num);
				String host = "smtp.naver.com";
				final String username = "youngho753";
				final String password = "fleamarket!";
				int port = 465;
				
				String recipient =email;
				
				String subject = "FleaMarket 임시비밀번호 발송" ;
				String content = "임시비밀번호 : [" +num+ "] 로그인 이후 비밀번호 변경을 권장합니다.";
				
				Properties props = System.getProperties();
				
				
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", port);
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.ssl.enable", "true");
				props.put("mail.smtp.ssl.trust", host);
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
						return new javax.mail.PasswordAuthentication(username, password);
					}
				});
				session.setDebug(true);
				
				Message mimeMessage = new MimeMessage(session);
				mimeMessage.setFrom(new InternetAddress("youngho753@naver.com"));
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				
				mimeMessage.setSubject(subject);
				mimeMessage.setText(content);
				
				Transport.send(mimeMessage);
				
				System.out.println("전송성공 email :" + email);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(result);
		}
		
		else // id/email 틀렸을때 
		{
			out.println(result);
		}
		
		
		
		
	}

}
