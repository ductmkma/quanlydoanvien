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
import com.zent.dao.PayUnionistDAO;
import com.zent.dao.UnionistDAO;
import com.zent.entity.PayUnionist;
import com.zent.entity.Unionist;

/**
 * Servlet implementation class PayUnionistServlet
 */
@WebServlet("/quanlydoanphi")
@MultipartConfig
public class PayUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UnionistDAO unionistDAO = new UnionistDAO();
	private PayUnionistDAO payDAO = new PayUnionistDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayUnionistServlet() {
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
			List<Unionist> listUnionist = new ArrayList<Unionist>();
			listUnionist = unionistDAO.getAllByUnit(Long.parseLong(request
					.getSession(false).getAttribute("units_id").toString()));
			List<PayUnionist> listPay = new ArrayList<PayUnionist>();
			listPay = payDAO.getAll();
			request.setAttribute("listPay", listPay);
			request.setAttribute("listUnionist", listUnionist);
			request.getRequestDispatcher("/pages/quanlydoanphi.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		Long unionist_id = Long.parseLong(request.getParameter("unionist_id"));
		int month = Integer.parseInt(request.getParameter("month"));
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		int year = Integer.parseInt(sdf.format(dateNow));
		SimpleDateFormat sdfCR = new SimpleDateFormat("YYYY-MM-dd");
		String created_at = sdfCR.format(dateNow);
		String updated_at = sdfCR.format(dateNow);
		int status = Integer.parseInt(request.getParameter("checked"));
		PayUnionist payUnionist = new PayUnionist(unionist_id, month, status,
				year, created_at);
		if (payDAO.check(payUnionist) == false) {
			payDAO.insert(payUnionist);
			response.getWriter().write("Nộp thành công !");
		} else if (payDAO.check(payUnionist) && status == 0) {
			PayUnionist payUnionistUpdate = new PayUnionist(unionist_id, month,
					status, year, "", updated_at);
			payDAO.update(payUnionistUpdate);
			response.getWriter().write("deleted");
		} else if (payDAO.check(payUnionist) && status == 1) {
			PayUnionist payUnionistUpdate = new PayUnionist(unionist_id, month,
					status, year, "", updated_at);
			payDAO.update(payUnionistUpdate);
			response.getWriter().write("added");
		}

	}

}
