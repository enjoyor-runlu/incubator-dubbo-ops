package com.enjoyor.dubbo.monitor.simple.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

/**
 * 
 * @author Tempest
 *
 */
public final class JDBCUtil {

	private static final Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

	public static final String drvierName;

	public static final String url;

	public static final String userName;

	public static final String password;

	static {
		// 读取资源文件
		Properties proobj = PropertiesUtil.loadProperties("conf/env.properties");
		drvierName = (String) proobj.get("db.driverName");
		url = (String) proobj.get("db.url");
		userName = (String) proobj.get("db.userName");
		password = (String) proobj.get("db.password");
	}

	public static void executeUpdate(String sql) {
		// 加载数据库驱动
		try {
			Class.forName(drvierName);// JDBC通用接口和Oracle数据库驱动包关联
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		}

		// 创建数据库连接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		try {
			Statement stmt = conn.createStatement();// 返回的是一个数据库操作对象（网络通信的输入输出流）
			stmt.executeUpdate(sql);// 执行数据库操作
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		// 关闭连接
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
