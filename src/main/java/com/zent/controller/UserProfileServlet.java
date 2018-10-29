package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.UnionistDAO;
import com.zent.entity.Province;
import com.zent.util.SecurityUtil;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/trangcanhan")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("name") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			request.getRequestDispatcher("/pages/userprofile.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("change")){
			String email = request.getParameter("email");
			String passold = SecurityUtil.md5(request.getParameter("passold"));
			System.out.println(passold);
			String passnew = SecurityUtil.md5(request.getParameter("passnew"));
			if(new UnionistDAO().checkPassword(email, passold)==0||passold.equals("d41d8cd98f00b204e9800998ecf8427e")){
				response.getWriter().write("error");
			}else{
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String updated_at = sdf.format(date);
				new UnionistDAO().updatePassword(email, passnew, updated_at);
				
			}
		}
		
	}

}
