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
import com.zent.dao.InputMoneyDAO;
import com.zent.entity.InputMoney;
import com.zent.entity.Spent;

/**
 * Servlet implementation class ListInputMoneyServlet
 */
@WebServlet("/listinputmoney")
@MultipartConfig
public class ListInputMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InputMoneyDAO inputMoneyDAO = new InputMoneyDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListInputMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		List<InputMoney> listInputMoney = new ArrayList<InputMoney>();
		listInputMoney = inputMoneyDAO.getAll(Long.parseLong(request.getSession(false).getAttribute("units_id").toString()));
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listInputMoney).getAsJsonArray();
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("edit")){
			response.setCharacterEncoding("UTF-8");
			List<InputMoney> InputMoneyById = new ArrayList<InputMoney>();
			InputMoneyById = inputMoneyDAO.getById(Long.parseLong(request.getParameter("id")));
			response.setContentType("application/json");
			Gson gson = new Gson();
			//cái này là để tạo đối tượng json kiểu danh sách
			JsonArray arr = gson.toJsonTree(InputMoneyById).getAsJsonArray();
			//cái này là tạo 1 đối tượng json, phải tạo thêm cái array vì đầu vào của hàm add nó bắt buộc phải là đối tượng json khác
			JsonObject json = new JsonObject();
			json.add("data", arr);
			response.getWriter().write(json.toString());
		}
	}

}
