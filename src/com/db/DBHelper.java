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
 * @category ���ݿ�����
 * @author WOM
 *
 */
public class DBHelper {
	private static Connection conn = null;
	private static PreparedStatement prestat = null;
	private static Properties prop = null;
	
	//static�飬�����һ�α�����ʱִ��һ�Σ�ִֻ��һ�Ρ�
	static {
		//����Properties����
		prop = new Properties();
		//��ȡdb.properties�ļ���
		InputStream inStream = DBHelper.class.getResourceAsStream("db.properties");
		try {
			//�������ļ����ص�Properties������ȥ
			prop.load(inStream);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("���ݿ����ʧ�ܣ�����");
		} catch (IOException e) {

			e.printStackTrace();
			System.err.println("����db.properties�ļ�ʧ��");
		}
	}
	/**
	 * 	1.�������ݿ�����
	 * 	2.�ر����ݿ�����
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
				System.err.println("���ݿ����Ӵ���ʧ�ܣ�����");
			}
			
		}
	}
	@Test
	public void test() {
		this.getConnection();
	}
	/**
	 * 	�ر����ݿ�����
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
	 * 3.ִ�в�ѯ����
	 * @param sql
	 * @param objects �ɱ䳤�ȲΣ���ָ�˴����Բ���������Ҳ���Դ�һ����������,ʹ��ʱ����������
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
	 * 4. ִ���������޸ġ�ɾ��sql
	 * @param sql
	 * @param objs
	 * @return ӡ������
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
