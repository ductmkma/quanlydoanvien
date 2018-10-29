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
import com.zent.dao.UnionistDAO;
import com.zent.entity.Unionist;
import com.zent.entity.Units;

/**
 * Servlet implementation class ListUnionistByUnits
 */
@WebServlet("/listunionist")
public class ListUnionistByUnitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UnionistDAO unionistDAO = new UnionistDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUnionistByUnitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		List<Unionist> listUnionist = new ArrayList<Unionist>();
		listUnionist = unionistDAO.getAllByUnit(Long.parseLong(request.getSession(false).getAttribute("units_id").toString()));
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listUnionist).getAsJsonArray();
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
