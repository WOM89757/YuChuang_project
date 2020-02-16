package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.model.goodsmodel;

@WebServlet("/goodsdelete.action")
public class GoodsdeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsdeleteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		//创建商品数据访问对象
		GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		int i = goodsDao.delete(goodsid);
		//将商品列表放到作用域当中
		
		
		request.getRequestDispatcher("management.action?do=goodslist").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
