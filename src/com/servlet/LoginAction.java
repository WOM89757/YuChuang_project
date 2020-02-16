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
 * @category ��¼������
 * @author WOM
 *
 */
@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	//��������ı��뷽ʽ
		  	request.setCharacterEncoding("utf-8");
		  	String verCode = request.getParameter("captcha");
		  	if (!CaptchaUtil.ver(verCode, request)) {
		          CaptchaUtil.clear(request);  // ���session�е���֤��
		          request.setAttribute("msg", "��֤�벻��ȷ");
		            String message="��֤�벻��ȷ,���������룡";
		            request.setAttribute("message", message);
		          //����ת��
		          request.getRequestDispatcher("goodslist.action").forward(request, response);
		          return;
		          
		      }
		  	CaptchaUtil.clear(request);  // ���session�е���֤��
		  	//get��ʽ�ύ
		  	String username = request.getParameter("username");
		  	String password = request.getParameter("password");
		  	//������Ч��У��
		  	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || !StringUtils.isEqLength(password, 6)) {
		  		request.setAttribute("msg", "�û��������벻��ȷ");
	            String message="�û��������벻��ȷ����";
	            request.setAttribute("message", message);
		          //����ת��
		  		request.getRequestDispatcher("goodslist.action").forward(request, response);
		          return;
		  	}
		  	
		  //��֤�û���������
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
		  			//�������ݷ��ʶ���
		  			GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		  			List<goodsmodel> list = goodsDao.findGoodList();
		  			//����Ʒ�б�ŵ���������
		  			request.setAttribute("goodslist", list);
		  			request.getRequestDispatcher("admin.jsp").forward(request, response);

		  			
		  		}else {
		  		
		  			request.getRequestDispatcher("goodslist.action").forward(request, response);
		  		}
		  		
		  		
		  	}else {
		  		request.setAttribute("msg", "�û��������벻��ȷ");
	            String message="�û��������벻��ȷ�����������룡��";
	            request.setAttribute("message", message);
		          //����ת��
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
