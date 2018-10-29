package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.PermissionRoleDAO;
import com.zent.dao.UserDAO;
import com.zent.entity.PRGroupByRoleId;
import com.zent.entity.PermissionRole;
import com.zent.entity.RoleUser;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class RoleUserServlet
 */
@WebServlet("/quanlytaikhoan/vaitro")
@MultipartConfig
public class RoleUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
	private PermissionRoleDAO permissionRoleDAO = new PermissionRoleDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleUserServlet() {
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
			List<RoleUser> listRoleUser = new ArrayList<RoleUser>();
			listRoleUser = userDAO.getAllRoleUser();
			request.setAttribute("listRoleUser", listRoleUser);
			List<PRGroupByRoleId> listPRGroupByRoleId = new ArrayList<PRGroupByRoleId>();
			listPRGroupByRoleId = permissionRoleDAO.getAllGroupByRoleId();
			request.setAttribute("listPRGroupByRoleId", listPRGroupByRoleId);
			List<Unionist> listRoleId = new ArrayList<Unionist>();
			listRoleId = permissionRoleDAO.getRoleId();
			request.setAttribute("listRoleId", listRoleId);
			request.getRequestDispatcher("/pages/vaitrotaikhoan.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long unionist_id = Long.parseLong(request.getParameter("user_id"));
		Long role_id = Long.parseLong(request.getParameter("role_id"));
		String checked = request.getParameter("checked");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String updated_at = sdf.format(dateNow);
		if (checked.equals("")) {
			userDAO.update(unionist_id, role_id, updated_at);
			response.getWriter().write("added");
		} else if (checked.equals("1")) {
			userDAO.update(unionist_id, 2l, updated_at);
			response.getWriter().write("deleted");
		} else if (checked.equals("0")) {
			userDAO.update(unionist_id, role_id, updated_at);
			response.getWriter().write("added");
		}
	}

}
