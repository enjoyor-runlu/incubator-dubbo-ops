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
		// ��ȡ��Դ�ļ�
		Properties proobj = PropertiesUtil.loadProperties("conf/env.properties");
		drvierName = (String) proobj.get("db.driverName");
		url = (String) proobj.get("db.url");
		userName = (String) proobj.get("db.userName");
		password = (String) proobj.get("db.password");
	}

	public static void executeUpdate(String sql) {
		// �������ݿ�����
		try {
			Class.forName(drvierName);// JDBCͨ�ýӿں�Oracle���ݿ�����������
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		}

		// �������ݿ�����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		try {
			Statement stmt = conn.createStatement();// ���ص���һ�����ݿ������������ͨ�ŵ������������
			stmt.executeUpdate(sql);// ִ�����ݿ����
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		// �ر�����
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
