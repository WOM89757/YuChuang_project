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
import com.dao.ReviewsDaoImpl;
import com.db.DBHelper;
import com.model.goodsmodel;
import com.model.reviewsmodel;
import com.model.usermodel;

@WebServlet("/management.action")
public class MangementAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MangementAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dowhat=request.getParameter("do");
		if(dowhat.equals("goodslist")) {
			//创建数据访问对象
			GoodsDaoImpl goodsDao = new GoodsDaoImpl();
			List<goodsmodel> list = goodsDao.findGoodList();
			//将商品列表放到作用域当中
			request.setAttribute("goodslist", list);
			
			//创建数据访问对象
			List<usermodel> userlist = new ArrayList<usermodel>();
			try {
				DBHelper db = new DBHelper();
				String sql = "select * from user ";
				ResultSet result = db.executeQuery(sql);
				usermodel user=new usermodel() ;
				while (result.next()) {
					user =  user.createUser(result);
					userlist.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将商品列表放到作用域当中
			request.setAttribute("userslist", userlist);
			
			
			ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
			List<reviewsmodel> reviewslist = reviewsDao.findReviewsList();

			//将商品列表放到作用域当中
			request.setAttribute("reviewslist", reviewslist);
			
			
			
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
