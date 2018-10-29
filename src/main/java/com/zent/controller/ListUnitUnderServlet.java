package com.zent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.UnitsDAO;
import com.zent.entity.Roles;
import com.zent.entity.Units;

/**
 * Servlet implementation class ListUnitUnderServlet
 */
@WebServlet("/listunitunder")
public class ListUnitUnderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UnitsDAO unitsDAO = new UnitsDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUnitUnderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		response.setCharacterEncoding("UTF-8");
		List<Units> listUnitsUnder = new ArrayList<Units>();
		listUnitsUnder = unitsDAO.getAllUnitsUnder(units_id);
		response.setContentType("application/json");
		Gson gson = new Gson();
		//cái này là để tạo đối tượng json kiểu danh sách
		JsonArray arr = gson.toJsonTree(listUnitsUnder).getAsJsonArray();
		//cái này là tạo 1 đối tượng json, phải tạo thêm cái array vì đầu vào của hàm add nó bắt buộc phải là đối tượng json khác
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
