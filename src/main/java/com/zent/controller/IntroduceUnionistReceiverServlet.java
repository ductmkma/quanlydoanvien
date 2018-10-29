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
import com.zent.dao.ConvertUnionistDAO;
import com.zent.entity.ConvertUnionist;

/**
 * Servlet implementation class IntroduceUnionistReceiverServlet
 */
@WebServlet("/waittingconfirmreceiver")
@MultipartConfig
public class IntroduceUnionistReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConvertUnionistDAO convertUnionistDAO = new ConvertUnionistDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroduceUnionistReceiverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		Long units_id_old = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		List<ConvertUnionist> listWattingConfirmReceiver = new ArrayList<ConvertUnionist>();
		listWattingConfirmReceiver = convertUnionistDAO.getAllWattingConfirmReceiver(units_id_old);
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listWattingConfirmReceiver).getAsJsonArray();
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
