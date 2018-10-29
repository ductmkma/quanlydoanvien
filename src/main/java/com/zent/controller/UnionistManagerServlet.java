package com.zent.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import com.zent.dao.ConvertUnionistDAO;
import com.zent.dao.UnionistDAO;
import com.zent.dao.UnitsDAO;
import com.zent.entity.ConvertUnionist;
import com.zent.entity.Province;
import com.zent.entity.Unionist;
import com.zent.entity.Units;
import com.zent.util.ConnectionUtil;
import com.zent.util.FileUtil;

/**
 * Servlet implementation class UnionistManagerServlet
 */
@WebServlet("/quanlydoanvien")
@MultipartConfig
public class UnionistManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPLOAD_FOLDER_PATH;
	private UnionistDAO unionistDAO = new UnionistDAO();
	private ConvertUnionistDAO convertUnionistDAO = new ConvertUnionistDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnionistManagerServlet() {
		super();
		InputStream inputStream = ConnectionUtil.class.getClassLoader()
				.getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			UPLOAD_FOLDER_PATH = properties.getProperty("path");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("name") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			String action = request.getParameter("action");
			if (action != null && action.equals("delete")) {
				String code = request.getParameter("id");
				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String deleted_at = sdf.format(dateNow);
				Unionist unionist = new Unionist(code, deleted_at);
				unionistDAO.delete(unionist);
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson("deleted"));

			} else {
				List<Province> listProvince = new ArrayList<Province>();
				listProvince = unionistDAO.getAllProvince();
				request.setAttribute("listProvince", listProvince);
				List<Unionist> listUnionist = new ArrayList<Unionist>();
				listUnionist = unionistDAO
						.getAllByUnit(Long.parseLong(request.getSession(false)
								.getAttribute("units_id").toString()));
				request.setAttribute("listUnionist", listUnionist);

				request.getRequestDispatcher("/pages/quanlydoanvien.jsp")
						.forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String code_unionist = request.getParameter("code_unionist");
		if (action.equals("check1")) {
			Map<String, Boolean> error = new HashMap<String, Boolean>();
			if (unionistDAO.checkExistEmail(email) > 0) {
				error.put("email", false);
			} else {
				error.put("email", true);
			}
			if (unionistDAO.checkExistCodeUnionist(code_unionist) > 0) {
				error.put("code", false);
			} else {
				error.put("code", true);
			}
			response.getWriter().write(new Gson().toJson(error));
		} else {
			FileUtil upload = new FileUtil();
			String fullPath = upload.uploadFile(request, UPLOAD_FOLDER_PATH,
					"avata");
			if (action.equals("insert")) {
				String code = request.getParameter("code_unioinist");
				String avata = "";
				if (!fullPath.isEmpty()) {
					avata = "image?name=" + new File(fullPath).getName();
				} else {
					avata = "image?name=avata.png";
				}
				String name = request.getParameter("name");
				String birthday = request.getParameter("birthday");
				String gender = request.getParameter("gender");
				email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String home_town = request.getParameter("home_town");
				String province = request.getParameter("province");
				String district = request.getParameter("district");
				String town = request.getParameter("town");
				String village = request.getParameter("village");
				String nation = request.getParameter("nation");
				String relligion = request.getParameter("relligion");
				String academic_level = request.getParameter("academic_level");
				String qualification = request.getParameter("qualification");
				String political_theory = request
						.getParameter("political_theory");
				code_unionist = request.getParameter("code_unioinist");
				String day_on_unionist = request
						.getParameter("day_on_unionist");
				String address_on_unionist = request
						.getParameter("address_on_unionist");
				String competence = request.getParameter("competence");
				String day_on_party = request.getParameter("day_on_party");
				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String created_at = sdf.format(dateNow);
				Long units_id = Long.parseLong(request.getSession(false)
						.getAttribute("units_id").toString());
				String units_name = convertUnionistDAO.getNameUnits(units_id);
				Long role_id = 2l;
				Unionist unionist = new Unionist(code, avata, name, birthday,
						gender, email, phone, home_town, province, district,
						town, village, nation, relligion, academic_level,
						qualification, political_theory, code_unionist,
						day_on_unionist, address_on_unionist, competence,
						day_on_party, created_at, units_id, role_id);
				unionistDAO.insert(unionist);
				ConvertUnionist convertUnionist = new ConvertUnionist(code,
						units_id, units_id, units_name, created_at, 1,
						created_at);
				convertUnionistDAO.insertUnionist(convertUnionist);
				response.sendRedirect(request.getContextPath()
						+ "/quanlydoanvien");
			} else if (action.equals("check")) {
				Long unionist_id = Long.parseLong(request.getParameter("id"));
				int year = Integer.parseInt(request.getParameter("year"));
				int count = unionistDAO.checkPayUnionist(year, unionist_id);
				response.setContentType("application/json");
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(count));
			} else if (action.equals("loadunits")) {
				UnitsDAO unitDAO = new UnitsDAO();
				List<Units> listUnitByTypeId = unitDAO.getListByTypeUnits(Long
						.parseLong(request.getSession(false)
								.getAttribute("units_id").toString()));
				response.setContentType("application/json");
				Gson gson = new Gson();
				JsonArray arr = gson.toJsonTree(listUnitByTypeId)
						.getAsJsonArray();
				JsonObject json = new JsonObject();
				json.add("data", arr);
				System.out.println(json.toString());
				response.getWriter().write(json.toString());
			} else if (action.equals("edit-acc")) {
				code_unionist = request.getParameter("codeUnionist");
				Long typeacc = Long.parseLong(request.getParameter("typeacc"));
				Date dateNow = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String updated_at = sdf.format(dateNow);
				Unionist unionist = new Unionist();
				unionist.setRole_id(typeacc);
				unionist.setUpdated_at(updated_at);
				unionist.setCode_unionist(code_unionist);
				unionistDAO.updateRoleId(unionist);
				new ListUserServlet().doGet(request, response);
			}
		}
		if (action.equals("edit")) {
			FileUtil upload = new FileUtil();
			String fullPath = upload.uploadFile(request, UPLOAD_FOLDER_PATH,
					"avata");
			String code = request.getParameter("code");
			String avata = "";
			if (!fullPath.isEmpty()) {
				avata = "image?name=" + new File(fullPath).getName();
			} else {
				avata = "image?name=avata.png";
			}
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			String gender = request.getParameter("gender");
			email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String home_town = request.getParameter("home_town");
			String province = request.getParameter("province");
			String district = request.getParameter("district");
			String town = request.getParameter("town");
			String village = request.getParameter("village");
			String nation = request.getParameter("nation");
			String relligion = request.getParameter("relligion");
			String academic_level = request.getParameter("academic_level");
			String qualification = request.getParameter("qualification");
			String political_theory = request.getParameter("political_theory");
			code_unionist = request.getParameter("code_unioinist");
			String day_on_unionist = request.getParameter("day_on_unionist");
			String address_on_unionist = request
					.getParameter("address_on_unionist");
			String competence = request.getParameter("competence");
			String day_on_party = request.getParameter("day_on_party");
			Date dateNow = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String updated_at = sdf.format(dateNow);
			Unionist unionist = new Unionist(code, avata, name, birthday, gender, email, phone, home_town, province, district, town, village, nation, relligion, academic_level, qualification, political_theory, day_on_unionist, address_on_unionist, competence, day_on_party, updated_at);
			unionistDAO.update(unionist);
			response.sendRedirect(request.getContextPath() + "/quanlydoanvien");
		}
	}
}
