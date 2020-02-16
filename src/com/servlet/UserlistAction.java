package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.db.DBHelper;
import com.model.goodsmodel;
import com.model.usermodel;

@WebServlet("/userlist.action")
public class UserlistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserlistAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建数据访问对象
		List<usermodel> list = new ArrayList<usermodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "select * from user ";
			ResultSet result = db.executeQuery(sql);
			usermodel user=new usermodel() ;
			while (result.next()) {
				user =  user.createUser(result);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//将商品列表放到作用域当中
		request.setAttribute("userslist", list);
		
		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
