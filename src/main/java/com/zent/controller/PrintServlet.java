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

import com.zent.dao.ReportUnionistDAO;
import com.zent.entity.Province;
import com.zent.entity.ReportUnionist;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet("/inbaocao")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ReportUnionistDAO reportUnionistDAO = new ReportUnionistDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
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
			request.setAttribute("list", reportUnionist);
			request.getRequestDispatcher("/pages/inbaocao.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
