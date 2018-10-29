package com.zent.controller;

import java.io.IOException;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.UnitsDAO;
import com.zent.entity.Units;
import com.zent.util.FileUtil;

/**
 * Servlet implementation class ReadFileExcelServlet
 */
@WebServlet("/readfileexcel")
@MultipartConfig
public class ReadFileExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFileExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		String a = session.getAttribute("typeId").toString();
		List<Units> listUnits = new ReadFromExcelFile().readUnitsFromExcelFile(FileUtil.getFileInputStream(request, "fileImport"),session.getAttribute("parentId").toString(),session.getAttribute("typeId").toString());
		UnitsDAO uniDao = new UnitsDAO();
		uniDao.insertListUnits(listUnits);
		response.sendRedirect(request.getContextPath()+"/quanlydonvi");
	}

}
