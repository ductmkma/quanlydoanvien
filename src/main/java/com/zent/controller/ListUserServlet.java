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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.RolesDAO;
import com.zent.dao.UserDAO;
import com.zent.entity.Roles;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/listuser")
@MultipartConfig
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		List<Unionist> listUser = new ArrayList<Unionist>();
		listUser = userDAO.getAll();
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listUser).getAsJsonArray();
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("getRole")){
			List<Roles> listRole = new ArrayList<Roles>();
			listRole = new RolesDAO().getRolesIdAndName();
			response.setContentType("application/json");
			Gson gson = new Gson();
			JsonArray arr = gson.toJsonTree(listRole).getAsJsonArray();
			JsonObject json = new JsonObject();
			json.add("data", arr);
			response.getWriter().write(json.toString());
		}
	}

}
