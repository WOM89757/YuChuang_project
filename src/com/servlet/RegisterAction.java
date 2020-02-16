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
 * @category ע�������
 * @author WOM
 */
@WebServlet("/register.action")
@MultipartConfig   /* ע���ʾ��servlet���Խ����ļ��������ע���л����������ļ��ϴ���һЩ���� */
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] types = { ".jpg", ".jpeg", ".png", ".bmp", ".gif" };
	  	String verCode = request.getParameter("captcha");


	
	  	if (!CaptchaUtil.ver(verCode, request)) {
	          CaptchaUtil.clear(request);  // ���session�е���֤��
	          request.setAttribute("msg", "��֤�벻��ȷ");
	          //����ת��
	          request.getRequestDispatcher("register.jsp").forward(request, response);
	          return;
	      }
	  	CaptchaUtil.clear(request);  // ���session�е���֤��
	  	//get��ʽ�ύ
	  	String username = request.getParameter("username");
	  	String password = request.getParameter("password");
	  	//������Ч��У��
	  	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || !StringUtils.isEqLength(password, 6)) {
	  		request.setAttribute("msg", "�û��������벻��ȷ");
	          //����ת��
	          request.getRequestDispatcher("register.jsp").forward(request, response);
	          return;
	  	}
	  	
	  //��֤�û���������
	  DBHelper db = new DBHelper();
		
	  String insertsql = "insert into user(username,password) values(?,?);";
	  HttpSession session = request.getSession();
	  try {
	  	int n = db.executeUpdate(insertsql, username,password);//���·��
	  	if(n>0) {
	  		
	  		request.setAttribute("msg", "ע��ɹ�");
	  		//response.sendRedirect("register.jsp");
	  		 request.getRequestDispatcher("goodslist.action").forward(request, response);
	  		
	  	}else {
	  		request.setAttribute("msg", "ע��ʧ��");
	          //����ת��
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
