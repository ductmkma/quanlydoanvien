package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.UnionistDAO;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class UserManagerServlet
 */
@WebServlet("/quanlytaikhoan")
@MultipartConfig
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UnionistDAO unionistDAO = new UnionistDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 if (session == null || session.getAttribute("name") == null) {
		        response.sendRedirect(request.getContextPath()+"/login");
		 }else{
		request.getRequestDispatcher("/pages/quanlytaikhoan.jsp").forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("delete")){
			String code = request.getParameter("id");
			Date dateNow = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String deleted_at = sdf.format(dateNow);
			Unionist unionist = new Unionist(code, deleted_at);
			unionistDAO.delete(unionist);
			new ListUserServlet().doGet(request, response);
		}
	}

}
