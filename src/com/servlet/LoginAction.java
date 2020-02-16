package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GoodsDaoImpl;
import com.db.DBHelper;
import com.model.goodsmodel;
import com.model.usermodel;
import com.util.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;

/**
 * @category 登录控制器
 * @author WOM
 *
 */
@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	//设置请求的编码方式
		  	request.setCharacterEncoding("utf-8");
		  	String verCode = request.getParameter("captcha");
		  	if (!CaptchaUtil.ver(verCode, request)) {
		          CaptchaUtil.clear(request);  // 清除session中的验证码
		          request.setAttribute("msg", "验证码不正确");
		            String message="验证码不正确,请重新输入！";
		            request.setAttribute("message", message);
		          //请求转发
		          request.getRequestDispatcher("goodslist.action").forward(request, response);
		          return;
		          
		      }
		  	CaptchaUtil.clear(request);  // 清除session中的验证码
		  	//get方式提交
		  	String username = request.getParameter("username");
		  	String password = request.getParameter("password");
		  	//数据有效性校验
		  	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || !StringUtils.isEqLength(password, 6)) {
		  		request.setAttribute("msg", "用户名或密码不正确");
	            String message="用户名或密码不正确！！";
	            request.setAttribute("message", message);
		          //请求转发
		  		request.getRequestDispatcher("goodslist.action").forward(request, response);
		          return;
		  	}
		  	
		  //验证用户名和密码
		  DBHelper db = new DBHelper();
		  String sql = "select * from user where username = ? and password = ?";
		  HttpSession session = request.getSession();
		  try {
		  	ResultSet result = db.executeQuery(sql, username,password);
		  	if(result.next()) {
		  		usermodel user = new usermodel().createUser(result);
		  		session.setAttribute("user", user);
		  		System.out.println( user.toString());
		  		if(user.getRange() == 1) {
		  			//创建数据访问对象
		  			GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		  			List<goodsmodel> list = goodsDao.findGoodList();
		  			//将商品列表放到作用域当中
		  			request.setAttribute("goodslist", list);
		  			request.getRequestDispatcher("admin.jsp").forward(request, response);

		  			
		  		}else {
		  		
		  			request.getRequestDispatcher("goodslist.action").forward(request, response);
		  		}
		  		
		  		
		  	}else {
		  		request.setAttribute("msg", "用户名或密码不正确");
	            String message="用户名或密码不正确，请重新输入！！";
	            request.setAttribute("message", message);
		          //请求转发
		  		request.getRequestDispatcher("goodslist.action").forward(request, response);
		  	}
		  } catch (SQLException e) {
		  	e.printStackTrace();
		  	request.getRequestDispatcher("goodslist.action").forward(request, response);
		  }


	  }
	
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  	doGet(req, resp);
	  }

}
