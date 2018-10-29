package com.zent.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zent.dao.ForgotPasswordDAO;
import com.zent.util.SecurityUtil;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotpassword")
@MultipartConfig
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForgotPasswordDAO forgotPassDAO = new ForgotPasswordDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/quenmatkhau.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email!=null){
			if(forgotPassDAO.checkEmail(email)){
				int newpass = rand(10000000, 99999999);
				try {
					sendMail(email, newpass);
				} catch (NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String password = SecurityUtil.md5(String.valueOf(newpass));
				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String updated_at = sdf.format(dateNow);
				forgotPassDAO.updatePassword(email, password, updated_at);
				response.sendRedirect(request.getContextPath()+"/login");
			}else{
				response.getWriter().write("notExist");
			}
		}
	}
	 public int rand(int min, int max) {
	        try {
	            Random rn = new Random();
	            int range = max - min + 1;
	            int randomNum = min + rn.nextInt(range);
	            return randomNum;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }
	public void sendMail(String email,int newpass) throws NoSuchProviderException{
		String smtpServer = "smtp.gmail.com";
		int port = 587;
		final String userid = "minhduccomputer.kma@gmail.com";//change accordingly
		final String password = "Duckien121115";//change accordingly
		String contentType = "text/html; charset=UTF-8";
		String subject = "RESET PASSWORD <NO-REPLY> ! ";
		String from = "Zent Group";
		String to = email;//some invalid address
		String bounceAddr = email;//change accordingly
		String body = "Chào bạn, mật khẩu mới của bạn là: "+newpass;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.from", bounceAddr);
		Session mailSession = Session.getInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userid, password);
		}
		});
		MimeMessage message = new MimeMessage(mailSession);
		try {
			message.addFrom(InternetAddress.parse(from));
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			message.setRecipients(Message.RecipientType.TO, to);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			message.setContent(body, contentType);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Transport transport = mailSession.getTransport();
		try {
		System.out.println("Sending ....");
		transport.connect(smtpServer, port, userid, password);
		transport.sendMessage(message,
		message.getRecipients(Message.RecipientType.TO));
		System.out.println("Sending done ...");
		} catch (Exception e) {
		System.err.println("Error Sending: ");
		e.printStackTrace();
		}
		try {
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
