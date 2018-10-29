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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.PermissionDAO;
import com.zent.dao.PermissionRoleDAO;
import com.zent.entity.Permission;
import com.zent.entity.PermissionRole;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class RolePermissionServlet
 */
@WebServlet("/vaitro/quyenhan")
@MultipartConfig
public class PermissonRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionDAO permissionDAO = new PermissionDAO();
	private PermissionRoleDAO permissonRoleDAO = new PermissionRoleDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissonRoleServlet() {
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
			List<PermissionRole> listPerRole = new ArrayList<PermissionRole>();
			listPerRole = permissonRoleDAO.getAll();
			request.setAttribute("listPerRole", listPerRole);
			request.getRequestDispatcher("/pages/vaitroquyenhan.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long role_id = Long.parseLong(request.getParameter("role_id"));
		Long permission_id = Long.parseLong(request
				.getParameter("permission_id"));
		String checked = request.getParameter("checked");
		PermissionRole permissionRole = new PermissionRole(role_id,
				permission_id);
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String created_at = sdf.format(dateNow);
		String updated_at = sdf.format(dateNow);
		if (permissonRoleDAO.check(permissionRole) == false
				&& checked.equals("")) {
			PermissionRole perRole = new PermissionRole(role_id, permission_id,
					created_at, "", "", 1);
			permissonRoleDAO.insert(perRole);
			response.getWriter().write("added");
		} else if (permissonRoleDAO.check(permissionRole) == true
				&& checked.equals("")) {
			PermissionRole perRole = new PermissionRole(role_id, permission_id,
					created_at, "", "", 1);
			permissonRoleDAO.insert(perRole);
			response.getWriter().write("added");
		} else if (permissonRoleDAO.check(permissionRole)
				&& checked.equals("1")) {
			PermissionRole perRole = new PermissionRole(role_id, permission_id,
					"", "", updated_at, 0);
			permissonRoleDAO.update(perRole);
			response.getWriter().write("deleted");
		} else if (permissonRoleDAO.check(permissionRole)
				&& checked.equals("0")) {
			PermissionRole perRole = new PermissionRole(role_id, permission_id,
					"", "", updated_at, 1);
			permissonRoleDAO.update(perRole);
			response.getWriter().write("added");
		}
	}

}
