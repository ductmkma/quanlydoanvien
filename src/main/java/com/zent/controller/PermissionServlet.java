package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.PermissionDAO;
import com.zent.entity.Permission;

/**
 * Servlet implementation class PermissionServlet
 */
@WebServlet("/quyenhan")
@MultipartConfig
public class PermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionDAO permissionDAO = new PermissionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("name") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {

			List<Permission> listPermission = new ArrayList<Permission>();
			listPermission = permissionDAO.getAll();
			request.setAttribute("listPermission", listPermission);
			request.getRequestDispatcher("/pages/quyenhan.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
