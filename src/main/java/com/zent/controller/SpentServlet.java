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
import com.zent.dao.SpentDAO;
import com.zent.entity.Spent;

/**
 * Servlet implementation class SpentServlet
 */
@WebServlet("/quanlytaichinh/khoanthu")
@MultipartConfig
public class SpentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SpentDAO spentDAO = new SpentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SpentServlet() {
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
			request.getRequestDispatcher("/pages/quanlykhoanthu.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if (action != null && action.equals("add")) {
			String content = request.getParameter("content");
			Long money = Long.parseLong(request.getParameter("money"));
			String date = request.getParameter("date");
			String receiver = request.getParameter("receiver");
			String created_at = sdf.format(dateNow);
			SimpleDateFormat formatPT = new SimpleDateFormat("YYYYMMddHHMMss");
			String code = "PT" + formatPT.format(dateNow);
			Long units_id = Long.parseLong(request.getSession(false)
					.getAttribute("units_id").toString());
			Spent spent = new Spent(code, content, money, receiver, date,
					units_id, created_at);
			spentDAO.insert(spent);
		} else if (action != null && action.equals("edit")) {
			Long id = Long.parseLong(request.getParameter("idSpent"));
			String content = request.getParameter("content");
			Long money = Long.parseLong(request.getParameter("money"));
			String date = request.getParameter("date");
			String receiver = request.getParameter("receiver");
			String updated_at = sdf.format(dateNow);
			Spent spent = new Spent(id, content, money, receiver, date,
					updated_at);
			spentDAO.edit(spent);
			reloadTable(request, response);
		} else if (action != null && action.equals("delete")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String deleted_at = sdf.format(dateNow);
			Spent spent = new Spent(id, deleted_at);
			spentDAO.delete(spent);
			reloadTable(request, response);
		}
	}

	public void reloadTable(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		List<Spent> listSpent = new ArrayList<Spent>();
		listSpent = spentDAO.getAll(Long.parseLong(request.getSession(false)
				.getAttribute("units_id").toString()));
		response.setContentType("application/json");
		Gson gson = new Gson();
		// cái này là để tạo đối tượng json kiểu danh sách
		JsonArray arr = gson.toJsonTree(listSpent).getAsJsonArray();
		// cái này là tạo 1 đối tượng json, phải tạo thêm cái array vì đầu vào
		// của hàm add nó bắt buộc phải là đối tượng json khác
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}

}
