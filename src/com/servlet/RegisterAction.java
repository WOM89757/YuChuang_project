package com.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.db.DBHelper;
import com.model.usermodel;
import com.util.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;

/**
 * @category 注册控制器
 * @author WOM
 */
@WebServlet("/register.action")
@MultipartConfig   /* 注解表示此servlet可以接受文件，在这个注解中还可以设置文件上传的一些配置 */
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] types = { ".jpg", ".jpeg", ".png", ".bmp", ".gif" };
	  	String verCode = request.getParameter("captcha");


	
	  	if (!CaptchaUtil.ver(verCode, request)) {
	          CaptchaUtil.clear(request);  // 清除session中的验证码
	          request.setAttribute("msg", "验证码不正确");
	          //请求转发
	          request.getRequestDispatcher("register.jsp").forward(request, response);
	          return;
	      }
	  	CaptchaUtil.clear(request);  // 清除session中的验证码
	  	//get方式提交
	  	String username = request.getParameter("username");
	  	String password = request.getParameter("password");
	  	//数据有效性校验
	  	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || !StringUtils.isEqLength(password, 6)) {
	  		request.setAttribute("msg", "用户名或密码不正确");
	          //请求转发
	          request.getRequestDispatcher("register.jsp").forward(request, response);
	          return;
	  	}
	  	
	  //验证用户名和密码
	  DBHelper db = new DBHelper();
		
	  String insertsql = "insert into user(username,password) values(?,?);";
	  HttpSession session = request.getSession();
	  try {
	  	int n = db.executeUpdate(insertsql, username,password);//相对路径
	  	if(n>0) {
	  		
	  		request.setAttribute("msg", "注册成功");
	  		//response.sendRedirect("register.jsp");
	  		 request.getRequestDispatcher("goodslist.action").forward(request, response);
	  		
	  	}else {
	  		request.setAttribute("msg", "注册失败");
	          //请求转发
	  		 request.getRequestDispatcher("goodslist.action").forward(request, response);
	  	}
	  } catch (SQLException e) {
	  	e.printStackTrace();
	  	 request.getRequestDispatcher("goodslist.action").forward(request, response);
	  }


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
