package com.zent.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.util.ConnectionUtil;

/**
 * Servlet implementation class DisplayImageServlet
 */
@WebServlet("/image")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static  String UPLOAD_FOLDER_PATH ;
	public static final Logger LOGGER = LoggerFactory.getLogger(DisplayImageServlet.class);
 
    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImageServlet() throws IOException {
        super();
		InputStream inputStream = ConnectionUtil.class.getClassLoader()
				.getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		UPLOAD_FOLDER_PATH = properties.getProperty("path");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	         String fileName = request.getParameter("name");             
	         FileInputStream fis = new FileInputStream(new File(UPLOAD_FOLDER_PATH+File.separator+fileName));
	         BufferedInputStream bis = new BufferedInputStream(fis);             
	         response.setContentType("image/*");
	         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
	         for (int data; (data = bis.read()) > -1;) {
	           output.write(data);
	         }             
	      }
	      catch(IOException e){
	    	  LOGGER.error(e.getMessage(),e);
	      }finally{
	          // close the streams
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
