package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.dao.ReviewsDaoImpl;
import com.model.goodsmodel;
import com.model.reviewsmodel;
import com.util.StringUtils;

@WebServlet("/reviews.action")
public class ReviewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewsAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dowhat=request.getParameter("do");
		if(dowhat.equals("getreviews")) {
	
			//request.setAttribute("goodslist", request.getAttribute("goodslist"));
			int goodsid = Integer.valueOf(request.getParameter("goodsid"));
			//创建数据访问对象
			ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
			List<reviewsmodel> list = reviewsDao.findReviewsList();
			//将商品列表放到作用域当中
			request.setAttribute("reviewslist", list);
			
			//创建商品数据访问对象
			GoodsDaoImpl goodsDao=new GoodsDaoImpl();
			List<goodsmodel> goodslist = goodsDao.findGoodsortList(goodsid);
			//将商品列表放到作用域当中
			request.setAttribute("goodslist", goodslist);
			
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			
		}
		if(dowhat.equals("addreviews")) {
			
			String message=request.getParameter("Message");
			String goodsid=request.getParameter("goodsid");
			String userid=request.getParameter("userid");
//			if(StringUtils.isEmpty(userid) ) {
//				System.out.println("login");
//				return;
//			}
			if(StringUtils.isEmpty(userid) ) {
				userid="1";
			}
			ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
			try {
				//将评论加入数据库中
				int i=reviewsDao.addReviews(Integer.parseInt(userid),Integer.parseInt( goodsid), message);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(userid);
			System.out.println("addreviews");
			int gid=Integer.parseInt(goodsid);
			
			//		查询商品信息
			GoodsDaoImpl goodsDao=new GoodsDaoImpl();
			goodsmodel goods= goodsDao.find(gid);
			//		放入seesion对象中
			request.setAttribute("goods", goods);
			
			
			
			//创建评论数据访问对象

			List<reviewsmodel> list = reviewsDao.findReviewsList();
			//将评论列表放到作用域当中
			request.setAttribute("reviewslist", list);
			
			//创建商品数据访问对象
			
			List<goodsmodel> goodslist =goodsDao.findGoodsortList(gid);
			//将商品列表放到作用域当中
			request.setAttribute("goodslist", goodslist);
			
		
			//		跳转到信息详情界面
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			
			
		}
		if(dowhat.equals("deletereviews")) {
			int reciewsid = Integer.valueOf(request.getParameter("reciewsid"));
			ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
			int i= reviewsDao.delete(reciewsid);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
