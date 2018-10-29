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
 * Servlet implementation class ConfirmReceiverServlet
 */
@WebServlet("/quanlychuyensinhhoat/xacnhanchuyenden")
@MultipartConfig
public class ConfirmReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConvertUnionistDAO convertUnionistDAO = new ConvertUnionistDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmReceiverServlet() {
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
			request.getRequestDispatcher("/pages/xacnhanchuyenden.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if(action!=null && action.equals("confirmlevel2")){
			String code_unionist = request.getParameter("code_unionist");
			Long units_id_new = Long.parseLong(request.getParameter("units_id_new"));
			String units_name_new = request.getParameter("units_name_new");
			String updated_at = sdf.format(dateNow);
			Long id = Long.parseLong(request.getParameter("id"));
			ConvertUnionist convertUnionist = new ConvertUnionist(code_unionist, updated_at, 0, updated_at); //sửa bản ghi ở đơn vị cũ
			convertUnionistDAO.updateStatusOld(convertUnionist);
			convertUnionist = new ConvertUnionist(id, units_id_new, units_name_new, updated_at, 1, updated_at);
			convertUnionistDAO.updateStatusNew(convertUnionist);
			convertUnionist = new ConvertUnionist(code_unionist, units_id_new, updated_at);
			convertUnionistDAO.updateUnitAfterConvert(convertUnionist);
			new IntroduceUnionistReceiverServlet().doGet(request, response);
		}
	}

}
