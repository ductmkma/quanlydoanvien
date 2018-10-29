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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zent.dao.InputMoneyDAO;
import com.zent.entity.InputMoney;
import com.zent.entity.Spent;

/**
 * Servlet implementation class InputMoneyServlet
 */
@WebServlet("/quanlytaichinh/khoanchi")
@MultipartConfig
public class InputMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InputMoneyDAO inputMoneyDAO = new InputMoneyDAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputMoneyServlet() {
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
			request.getRequestDispatcher("/pages/quanlykhoanchi.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Date dateNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if (action!=null&&action.equals("add")) {
			String content = request.getParameter("content");
			Long money = Long.parseLong(request.getParameter("money"));
			String date = request.getParameter("date");
			String sender = request.getParameter("sender");
			String created_at = sdf.format(dateNow);
			SimpleDateFormat formatPT = new SimpleDateFormat("YYYYMMddHHMMss");
			String code = "PC" + formatPT.format(dateNow);
			Long units_id = Long.parseLong(request.getSession(false).getAttribute("units_id").toString());
			InputMoney inputMoney = new InputMoney(code, content, money, sender, date, units_id, created_at);
			inputMoneyDAO.insert(inputMoney);
		}else if(action!=null&&action.equals("edit")){
			Long id = Long.parseLong(request.getParameter("idIpMoney"));
			String content = request.getParameter("content");
			Long money = Long.parseLong(request.getParameter("money"));
			String date = request.getParameter("date");
			String sender = request.getParameter("sender");
			String updated_at = sdf.format(dateNow);
			InputMoney inputMoney = new InputMoney(id, content, money, sender, date, updated_at);
			inputMoneyDAO.edit(inputMoney);
			reloadTable(request, response);
		}else if(action!=null&&action.equals("delete")){
			Long id = Long.parseLong(request.getParameter("id"));
			String deleted_at = sdf.format(dateNow);
			InputMoney inputMoney = new InputMoney(id, deleted_at);
			inputMoneyDAO.delete(inputMoney);
			reloadTable(request, response);
		}
	}
	public void reloadTable(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		List<InputMoney> listInputMoney = new ArrayList<InputMoney>();
		listInputMoney = inputMoneyDAO.getAll(Long.parseLong(request.getSession(false).getAttribute("units_id").toString()));
		response.setContentType("application/json");
		Gson gson = new Gson();
		//cái này là để tạo đối tượng json kiểu danh sách
		JsonArray arr = gson.toJsonTree(listInputMoney).getAsJsonArray();
		//cái này là tạo 1 đối tượng json, phải tạo thêm cái array vì đầu vào của hàm add nó bắt buộc phải là đối tượng json khác
		JsonObject json = new JsonObject();
		json.add("data", arr);
		response.getWriter().write(json.toString());
	}
	}

