package com.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;
/**
 * @category 数据库助手
 * @author WOM
 *
 */
public class DBHelper {
	private static Connection conn = null;
	private static PreparedStatement prestat = null;
	private static Properties prop = null;
	
	//static块，在类第一次被加载时执行一次，只执行一次。
	static {
		//创建Properties对象
		prop = new Properties();
		//读取db.properties文件流
		InputStream inStream = DBHelper.class.getResourceAsStream("db.properties");
		try {
			//就配置文件加载到Properties对象中去
			prop.load(inStream);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("数据库加载失败！！！");
		} catch (IOException e) {

			e.printStackTrace();
			System.err.println("加载db.properties文件失败");
		}
	}
	/**
	 * 	1.创建数据库连接
	 * 	2.关闭数据库连接
	 *  
	 *  
	 * @throws SQLException 
	 */
	
	public static void getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),prop.getProperty("password"));
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("数据库连接创建失败！！！");
			}
			
		}
	}
	@Test
	public void test() {
		this.getConnection();
	}
	/**
	 * 	关闭数据库连接
	 * @throws SQLException 
	 * 
	 */
	public static void close() throws SQLException {
		if(prestat != null) {
			prestat.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
	
	
	
	/**
	 * 3.执行查询方法
	 * @param sql
	 * @param objects 可变长度参，是指此处可以不传参数，也可以传一个或多个参数,使用时和数组类似
	 * @return
	 * @throws SQLException 
	 */
	public static ResultSet executeQuery(String sql, Object...objects) throws SQLException {
		getConnection();
		prestat = conn.prepareStatement(sql);
		setParams(objects);
		ResultSet result = prestat.executeQuery();
		return result;
		
	}
	
	/**
	 * 4. 执行新增、修改、删除sql
	 * @param sql
	 * @param objs
	 * @return 印象行数
	 * @throws SQLException
	 */
	
	public static int executeUpdate(String sql,Object...objs) throws SQLException {
		getConnection();
		prestat = conn.prepareStatement(sql);
		setParams(objs);
		return prestat.executeUpdate();
	}
	
	
	
	private static void setParams(Object... objs) throws SQLException {
		if(objs != null && objs.length > 0) {
			for (int i = 0; i < objs.length; i++) {
				prestat.setObject(i+1, objs[i]);
			}
		}
	}
}
