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
import com.zent.dao.RolesDAO;
import com.zent.entity.Roles;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/vaitro")
@MultipartConfig
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolesDAO roleDAO = new RolesDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
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
		request.getRequestDispatcher("/pages/vaitro.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if(action!=null&&action.equals("delete")){
			String id  = request.getParameter("id");
			String deleted_at = sdf.format(dateNow);
			Roles role = new Roles();
			role.setId(Long.parseLong(id));
			role.setDeleted_at(deleted_at);
			roleDAO.delete(role);
			tableReload(request, response);
		}else if(action!=null&&action.equals("edit")){
			String id = request.getParameter("idRole");
			String name = request.getParameter("name");
			String display_name = request.getParameter("display_name");
			String description = request.getParameter("description");
			String updated_at = sdf.format(dateNow);
			Roles role = new Roles(Long.parseLong(id), name, display_name, updated_at, description);
			roleDAO.edit(role);
			tableReload(request, response);
		}else if(action!=null&&action.equals("add")){
			String name = request.getParameter("name");
			String display_name = request.getParameter("display_name");
			String description = request.getParameter("description");
			String created_at = sdf.format(dateNow);
			Roles role = new Roles(name, display_name, created_at, description);
			roleDAO.insert(role);
			tableReload(request, response);
		}
	}
	public void tableReload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Roles> listRoles = new ArrayList<Roles>();
		listRoles = roleDAO.getAll();
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listRoles).getAsJsonArray();
		//cái này là tạo 1 đối tượng json, phải tạo thêm cái array vì đầu vào của hàm add nó bắt buộc phải là đối tượng json khác
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());	
	}
	

}
