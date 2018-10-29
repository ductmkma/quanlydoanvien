package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.UnitsDAO;
import com.zent.entity.Roles;
import com.zent.entity.Units;

/**
 * Servlet implementation class QuanLyDonViServlet
 */
@WebServlet("/quanlydonvi")
@MultipartConfig
public class UnitsManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UnitsDAO unitsDAO = new UnitsDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnitsManagerServlet() {
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
		        response.sendRedirect(request.getContextPath()+"/login");
		 }else{
		List<Units> listUnitsExceptDeleted = new ArrayList<Units>();
		List<Units> listUnits = new ArrayList<Units>();
		listUnitsExceptDeleted = unitsDAO.getAllExceptDeleted(Long.parseLong(request.getSession(false).getAttribute("units_id").toString()));
		listUnits = unitsDAO.getAll();
		request.setAttribute("listUnitsExceptDeleted", listUnitsExceptDeleted);
		request.setAttribute("listUnits", listUnits);
		request.getRequestDispatcher("/pages/quanlydonvi.jsp").forward(request,
				response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action.equals("insert")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int typeUnit = Integer.parseInt(request.getParameter("typeUnit"));
			Date dateNow = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			String createdAt = sdf.format(dateNow);
			Long parentId = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
			Units unit = new Units(name, address, phone, email, createdAt, parentId,typeUnit);
			unitsDAO.insert(unit);
			Cookie ck = new Cookie("alert", "1");
			ck.setMaxAge(4);
			response.addCookie(ck);
			response.sendRedirect(request.getContextPath()+"/quanlydonvi");
		}else if(action.equals("edit")){
			Long id = Long.parseLong(request.getParameter("code"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int typeUnit = Integer.parseInt(request.getParameter("typeUnit"));
			Date dateNow = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			String updatedAt = sdf.format(dateNow);
			Units unit = new Units(id, name, address, phone, email, updatedAt,typeUnit);
			unitsDAO.update(unit);
			response.sendRedirect(request.getContextPath()+"/quanlydonvi");
		} else if(action.equals("delete")){
			Long id = Long.parseLong(request.getParameter("id"));
			Date dateNow = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
			String deletedAt = sdf.format(dateNow);
			Units unit = new Units(id, deletedAt);
			unitsDAO.delete(unit);
			response.setCharacterEncoding("UTF-8");
			List<Units> listUnitsExceptDeleted = new ArrayList<Units>();
			listUnitsExceptDeleted = unitsDAO.getAllExceptDeleted(Long.parseLong(request.getSession(false).getAttribute("units_id").toString()));
			response.setContentType("application/json");
			Gson gson = new Gson();
			JsonArray arr = gson.toJsonTree(listUnitsExceptDeleted).getAsJsonArray();
			JsonObject json = new JsonObject();
			json.add("data", arr);
			response.getWriter().write(json.toString());
		}
		
		
	}

}
