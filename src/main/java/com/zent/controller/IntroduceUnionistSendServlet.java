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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.ConvertUnionistDAO;
import com.zent.entity.ConvertUnionist;
import com.zent.entity.Roles;

/**
 * Servlet implementation class ConvertUnionistServlet
 */
@WebServlet("/gioithieusinhhoat")
@MultipartConfig
public class IntroduceUnionistSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConvertUnionistDAO convertUnionistDAO = new ConvertUnionistDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IntroduceUnionistSendServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		Long units_id_old = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		List<ConvertUnionist> listWattingConfirm = new ArrayList<ConvertUnionist>();
		listWattingConfirm = convertUnionistDAO.getAllWattingConfirmofUnitsId(units_id_old);
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listWattingConfirm).getAsJsonArray();
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		if(action.equals("introduce")){
			String code_unionist = request.getParameter("code_unionist");
			Long units_id_new = Long.parseLong(request.getParameter("units_id_new"));
			Long units_id_old = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
			String created_at = sdf.format(dateNow);
			String units_name_new = request.getParameter("units_name_new");
			int status = 2;
			ConvertUnionist convertunionist = new ConvertUnionist(code_unionist, units_id_old, units_id_new, units_name_new, status, created_at);
			convertUnionistDAO.insert(convertunionist);
		}
	}
}
