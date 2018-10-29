package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.ReportUnionistDAO;
import com.zent.entity.Province;
import com.zent.entity.ReportUnionist;
import com.zent.entity.Roles;

/**
 * Servlet implementation class ReportUnionistManager
 */
@WebServlet("/baocaocongtacdoan")
public class ReportUnionistManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportUnionistDAO reportUnionistDAO = new ReportUnionistDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportUnionistManager() {
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
			request.getRequestDispatcher("/pages/baocaocongtacdoan.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
