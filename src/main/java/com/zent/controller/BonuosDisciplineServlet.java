package com.zent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zent.dao.BonuosDisciplineDAO;
import com.zent.entity.BonuosDiscipline;

/**
 * Servlet implementation class BonuosDisciplineServlet
 */
@WebServlet("/bonuosdiscipline")
public class BonuosDisciplineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BonuosDisciplineDAO bonuosDisciplineDAO = new BonuosDisciplineDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BonuosDisciplineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		int hinhThuc = Integer.parseInt(request.getParameter("hinhthuc"));
		String soQuyetDinh = request.getParameter("soquyetdinh");
		String noiDung = request.getParameter("noidung");
		String ngayRaQuyetDinh = request.getParameter("date");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String created_at = sdf.format(date);
		Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
		BonuosDiscipline bonuosDiscipline = new BonuosDiscipline(hinhThuc, code, units_id, noiDung, ngayRaQuyetDinh, soQuyetDinh, created_at);
		bonuosDisciplineDAO.insertBonuosDiscipline(bonuosDiscipline);
	}

}
