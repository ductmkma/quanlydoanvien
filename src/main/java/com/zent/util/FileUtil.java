package com.zent.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	public static InputStream getFileInputStream(HttpServletRequest request, String parameter){
		InputStream fileInputStream = null;
		try {
			Part file;
			file = request.getPart(parameter);
			fileInputStream = file.getInputStream();
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (ServletException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return fileInputStream;
	}
	public String uploadFile(HttpServletRequest request,String uploadPath,String parameter){
		String fullPath="";
		try {
			Part file;
			file = request.getPart(parameter);
			String fileName = getFileName(file);
			OutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(new File(uploadPath+"/"+fileName));
			fullPath = uploadPath+"/"+fileName;
			InputStream fileInputStream = file.getInputStream();
			int read = 0;
		    final byte[] bytes = new byte[1024];

		    while ((read = fileInputStream.read(bytes)) != -1) {
		    	fileOutputStream.write(bytes, 0, read);
		    }
		    fileInputStream.close();
		    fileOutputStream.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (ServletException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return fullPath;
		
	}
}
