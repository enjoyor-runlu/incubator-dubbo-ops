package com.enjoyor.dubbo.monitor.simple.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

/**
 * 
 * @author Tempest
 * 
 */
public final class JdbcUtil {

	private static final Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

	private static DataSource dataSource;

	static {
		// 读取资源文件
		Properties proobj = PropertiesUtil.loadProperties("conf/env.properties");

		try {
			dataSource = DruidDataSourceFactory.createDataSource(proobj);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static int executeUpdate(String sql, List<Object> parameters) {
		try {
			return JdbcUtils.executeUpdate(dataSource, sql, parameters);
		} catch (SQLException e) {
			logger.error(e);
		}

		return 0;
	}
}
