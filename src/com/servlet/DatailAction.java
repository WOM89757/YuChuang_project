package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.model.goodsmodel;
/**
 * @category 商品详细跳转action
 * @author WOM
 *
 */
@WebServlet("/detail.action")
public class DatailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DatailAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		获取商品ID
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		request.setAttribute("do", request.getParameter("do"));
		
		//		查询商品信息
		GoodsDaoImpl goodsDao=new GoodsDaoImpl();
		goodsmodel goods= goodsDao.find(goodsid);
		//		放入seesion对象中
		request.setAttribute("goods", goods);
		

		//		跳转到信息详情界面
		request.getRequestDispatcher("reviews.action").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
