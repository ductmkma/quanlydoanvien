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
import com.zent.dao.ReportUnionistDAO;
import com.zent.entity.ReportUnionist;

/**
 * Servlet implementation class ListReportUnionistServlet
 */
@WebServlet("/listreport")
public class ListReportUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReportUnionistDAO reportUnionistDAO = new ReportUnionistDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReportUnionistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		response.setCharacterEncoding("UTF-8");
		ReportUnionist rp = new ReportUnionist();
		List<ReportUnionist> reportUnionist = new ArrayList<ReportUnionist>();
		rp.setSumUnionist(reportUnionistDAO.getSumUnionistByUnits(units_id));
		rp.setNationUnionist(reportUnionistDAO.getNationUnionistByUnits(units_id));
		rp.setReligionUnionist(reportUnionistDAO.getReligionUnionistByUnits(units_id));
		rp.setParty(reportUnionistDAO.getReligionUnionistByUnits(units_id));
		rp.setUnionistCard(reportUnionistDAO.getCardUnionistByUnits(units_id));
		rp.setUnionistBook(reportUnionistDAO.getCardUnionistByUnits(units_id));
		rp.setUnionistNew(1);
		reportUnionist.add(rp);
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(reportUnionist).getAsJsonArray();
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
