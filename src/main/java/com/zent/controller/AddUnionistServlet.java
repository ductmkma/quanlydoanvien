package com.zent.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zent.dao.UnionistDAO;
import com.zent.entity.District;
import com.zent.entity.Province;
import com.zent.entity.Town;
import com.zent.entity.Unionist;
import com.zent.util.ConnectionUtil;
import com.zent.util.FileUtil;

/**
 * Servlet implementation class AddUnionistServlet
 */
@WebServlet("/quanlydoanvien/themmoi")
@MultipartConfig
public class AddUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UnionistDAO unionistDAO = new UnionistDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUnionistServlet() {
		super();

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
			List<Province> listProvince = new ArrayList<Province>();
			listProvince = unionistDAO.getAllProvince();
			request.setAttribute("listProvince", listProvince);
			request.getRequestDispatcher("/pages/themmoidoanvien.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String provinceId = request.getParameter("provinceId");
		if (provinceId != null) {
			response.setCharacterEncoding("UTF-8");
			List<District> listDistricts = new ArrayList<District>();
			listDistricts = unionistDAO.getDistrictByProvinceId(provinceId);
			response.setContentType("application/json");
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(listDistricts));
		} else {
			String districtId = request.getParameter("districtId");
			response.setCharacterEncoding("UTF-8");
			List<Town> listTowns = new ArrayList<Town>();
			listTowns = unionistDAO.getTownByDistrictId(districtId);
			response.setContentType("application/json");
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(listTowns));
		}

	}

}
