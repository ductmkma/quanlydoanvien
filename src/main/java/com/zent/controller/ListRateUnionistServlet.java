package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.RateUnionistDAO;
import com.zent.dao.ReportRateDAO;
import com.zent.entity.ReportRate;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class ListRateUnionistServlet
 */
@WebServlet("/listrate")
public class ListRateUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportRateDAO reportRateDAO = new ReportRateDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRateUnionistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		List<ReportRate> listReportRate = new ArrayList<ReportRate>();
		Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		String year = sdf.format(date);
		ReportRate reportRate = new ReportRate();
		reportRate.setSumRated(reportRateDAO.getSumRated(units_id));
		reportRate.setSumExcellent(reportRateDAO.getSumExcellent(units_id, year));
		reportRate.setSumRather(reportRateDAO.getSumRather(units_id, year));
		reportRate.setSumMedium(reportRateDAO.getSumMedium(units_id, year));
		reportRate.setSumWeak(reportRateDAO.getSumWeak(units_id, year));
		Long notRate = reportRateDAO.getSumRated(units_id)-reportRateDAO.getSumExcellent(units_id, year)-reportRateDAO.getSumRather(units_id, year)-reportRateDAO.getSumMedium(units_id, year)-reportRateDAO.getSumWeak(units_id, year);
		reportRate.setSumNotRate(notRate);
		listReportRate.add(reportRate);
		response.setContentType("application/json");
		Gson gson = new Gson();
		JsonArray arr = gson.toJsonTree(listReportRate).getAsJsonArray();
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
