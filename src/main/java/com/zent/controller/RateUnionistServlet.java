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
import javax.servlet.http.HttpSession;

import com.zent.dao.RateUnionistDAO;
import com.zent.entity.Province;
import com.zent.entity.RateUnionist;

/**
 * Servlet implementation class RateUnionistServlet
 */
@WebServlet("/danhgiaxeploai")
public class RateUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RateUnionistDAO rateUnionistDAO = new RateUnionistDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateUnionistServlet() {
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
			request.getRequestDispatcher("/pages/danhgiaxeploai.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code_unionist = request.getParameter("code");
		int rate_id = Integer.parseInt(request.getParameter("ratevalue"));
		Date currentTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		String year = sdf.format(currentTime);
		if(rateUnionistDAO.checkRateExist(code_unionist, year)>0){
			String updated_at = format.format(currentTime);
			RateUnionist rateUnionist = new RateUnionist(code_unionist, year, rate_id, updated_at);
			rateUnionistDAO.updateRateUnionist(rateUnionist);
		}else{
			String created_at = format.format(currentTime);
			Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
			RateUnionist rateUnionist = new RateUnionist(code_unionist, units_id, year, rate_id, created_at);
			rateUnionistDAO.insertRateUnionist(rateUnionist);
		}
	}

}
