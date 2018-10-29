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

import com.google.gson.Gson;
import com.zent.dao.LoginDAO;
import com.zent.entity.PermissionRoleUnitonist;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.SecurityUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = SecurityUtil.md5(request.getParameter("password"));
		Unionist unionist = new Unionist("", email, password);
		LoginDAO loginDAO = new LoginDAO();
		List<PermissionRoleUnitonist> listPerRoleUni = new ArrayList<PermissionRoleUnitonist>();
		String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		Units parentIdAndTypeId = loginDAO.getParentIdAndTypeId(email);
		if(loginDAO.checkLogin(unionist)){
			listPerRoleUni = loginDAO.getPermissionRoleByUnionistId(Long.parseLong(loginDAO.getIdByEmail(email)));
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60);
			session.setAttribute("listPerRoleUni", listPerRoleUni);
			session.setAttribute("parentId", parentIdAndTypeId.getParentId());
			session.setAttribute("typeId", parentIdAndTypeId.getTypeUnit());
			session.setAttribute("email", email);
			session.setAttribute("name", loginDAO.getNameUser(email));
			session.setAttribute("avata", path+loginDAO.getAvataUser(email));
			session.setAttribute("units_id", loginDAO.getUnitsId(email));
			session.setAttribute("units_name", loginDAO.getNameUnits(loginDAO.getUnitsId(email)));
			response.getWriter().print(true);
		}else{
			System.out.println("Thất bại");
			response.setContentType("application/json");
			Gson gson = new Gson();
			response.getWriter().print(false);
		}
	}
}
