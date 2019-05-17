package com.HanabiBoot.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceUtils {
	private static ComboPooledDataSource datasource=new ComboPooledDataSource();
	//static ComboPooledDataSource datasource = DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	
	/**
	 * 获取数据源
	 * @return 连接池
	 */
	public static DataSource getDataSource(){
		return datasource;
//		return ds;
	}
	
	/**
	 * 获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}
	
	
	
	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            连接
	 * @param st
	 *            语句执行者
	 * @param rs
	 *            结果集
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 *            连接
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * 释放语句执行者
	 * 
	 * @param st
	 *            语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * 释放结果集
	 * 
	 * @param rs
	 *            结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}
}
