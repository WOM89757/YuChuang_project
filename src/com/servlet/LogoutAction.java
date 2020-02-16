package com.servlet;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @category 注销控制器
 * @author WOM
 *
 */
@WebServlet("/logout.action")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public LogoutAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		


		//注销当前用户
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		//request.getSession().invalidate();

		request.getRequestDispatcher("goodslist.action").forward(request, response);
	





	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
