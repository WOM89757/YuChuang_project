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
			//�������ݷ��ʶ���
			ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
			List<reviewsmodel> list = reviewsDao.findReviewsList();
			//����Ʒ�б�ŵ���������
			request.setAttribute("reviewslist", list);
			
			//������Ʒ���ݷ��ʶ���
			GoodsDaoImpl goodsDao=new GoodsDaoImpl();
			List<goodsmodel> goodslist = goodsDao.findGoodsortList(goodsid);
			//����Ʒ�б�ŵ���������
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
				//�����ۼ������ݿ���
				int i=reviewsDao.addReviews(Integer.parseInt(userid),Integer.parseInt( goodsid), message);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(userid);
			System.out.println("addreviews");
			int gid=Integer.parseInt(goodsid);
			
			//		��ѯ��Ʒ��Ϣ
			GoodsDaoImpl goodsDao=new GoodsDaoImpl();
			goodsmodel goods= goodsDao.find(gid);
			//		����seesion������
			request.setAttribute("goods", goods);
			
			
			
			//�����������ݷ��ʶ���

			List<reviewsmodel> list = reviewsDao.findReviewsList();
			//�������б�ŵ���������
			request.setAttribute("reviewslist", list);
			
			//������Ʒ���ݷ��ʶ���
			
			List<goodsmodel> goodslist =goodsDao.findGoodsortList(gid);
			//����Ʒ�б�ŵ���������
			request.setAttribute("goodslist", goodslist);
			
		
			//		��ת����Ϣ�������
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
