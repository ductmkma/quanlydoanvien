package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.ConvertUnionistDAO;
import com.zent.entity.ConvertUnionist;

/**
 * Servlet implementation class ConvertUnionistManagerServlet
 */
@WebServlet("/quanlychuyensinhhoat/xacnhanchuyendi")
@MultipartConfig
public class ConfirmSendUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConvertUnionistDAO convertUnionistDAO = new ConvertUnionistDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmSendUnionistServlet() {
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
			request.getRequestDispatcher("/pages/xacnhanchuyendi.jsp")
					.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if(action.equals("confirmlevel1")){
			Long id = Long.parseLong(request.getParameter("id"));
			String updated_at = sdf.format(dateNow);
			int status = 3; //Trạng thái chờ đoàn bên kia xác nhận.
			ConvertUnionist convertUnionist = new ConvertUnionist();
			convertUnionist.setId(id);
			convertUnionist.setStatus(status);
			convertUnionist.setUpdated_at(updated_at);
			convertUnionistDAO.edit(convertUnionist);
			new IntroduceUnionistSendServlet().doGet(request, response);
		}
	}

}
