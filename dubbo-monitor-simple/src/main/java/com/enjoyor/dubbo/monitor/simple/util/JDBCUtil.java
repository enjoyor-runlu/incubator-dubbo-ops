package com.enjoyor.dubbo.monitor.simple.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
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

	public static DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(drvierName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}

	public static void executeUpdate(String sql) {
		DataSource dataSource = getDataSource();

		// 创建数据库连接
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();// 返回的是一个数据库操作对象（网络通信的输入输出流）
			stmt.executeUpdate(sql);// 执行数据库操作
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// 关闭连接
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
}
