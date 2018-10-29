package com.zent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zent.dao.UnionistDAO;
import com.zent.dao.UnitsDAO;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.FileUtil;

/**
 * Servlet implementation class ReadFileExcelUnionistServlet
 */
@WebServlet("/readfileexcelunionist")
@MultipartConfig
public class ReadFileExcelUnionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFileExcelUnionistServlet() {
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
		HttpSession session  = request.getSession();
		List<Unionist> listUnionist = new ReadFromExcelFile().readUnionistFromExcelFile(FileUtil.getFileInputStream(request, "fileImport"),Long.parseLong(session.getAttribute("units_id").toString()));
		UnionistDAO unionistDAO = new UnionistDAO();
		unionistDAO.insertListUnionistByExcel(listUnionist);
		response.sendRedirect(request.getContextPath()+"/quanlydoanvien");
	}

}
