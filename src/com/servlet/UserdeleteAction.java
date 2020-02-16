package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.db.DBHelper;

/**
 * Servlet implementation class UserdeleteAction
 */
@WebServlet("/userdelete.action")
public class UserdeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserdeleteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usersid = Integer.valueOf(request.getParameter("usersid"));
		//������Ʒ���ݷ��ʶ���
		
		DBHelper db = new DBHelper();
		String sql = "delete from user where id = ?";
		try {
			int i = db.executeUpdate(sql,usersid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//����Ʒ�б�ŵ���������
		
		
		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
