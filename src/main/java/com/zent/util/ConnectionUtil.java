package com.zent.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionUtil {
	public static String driver;
	public static String hostName;
	public static String port;
	public static String databaseName;
	public static String username;
	public static String password;
	public static final Logger LOGGER = LoggerFactory.getLogger(ConnectionUtil.class);
	public static Connection open() throws ClassNotFoundException, SQLException {
		try {
			InputStream inputStream = ConnectionUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			driver = properties.getProperty("driver");
			hostName = properties.getProperty("hostName");
			port = properties.getProperty("port");
			databaseName = properties.getProperty("databaseName");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		}
		Class.forName(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostName + ":" + port + "/" + databaseName, username,
				password);
		return conn;
	}

}
