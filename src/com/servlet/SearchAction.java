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
@WebServlet("/search.action")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dowhat=request.getParameter("do");
		String fwhere=request.getParameter("fwhere");
		if(dowhat.equals("searchsort")) {
			//	��ȡ��ƷID
			String gsort = request.getParameter("gsort");
			//		��ѯ��Ʒ��Ϣ
			GoodsDaoImpl goodsDao=new GoodsDaoImpl();
			List<goodsmodel> goodslist = goodsDao.findGoodsortList(gsort);
			//����Ʒ�б�ŵ���������
			request.setAttribute("goodslist", goodslist);
			if(fwhere.equals("manager")){
				//�������ݷ��ʶ���
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
				request.setAttribute("userslist", userlist);
				
				
				ReviewsDaoImpl reviewsDao = new ReviewsDaoImpl();
				List<reviewsmodel> reviewslist = reviewsDao.findReviewsList();

				//����Ʒ�б�ŵ���������
				request.setAttribute("reviewslist", reviewslist);
				//����Ʒ�б�ŵ���������
				request.setAttribute("userslist", userlist);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(dowhat.equals("searchname")) {
//			��ȡ��ƷID
					String gname = request.getParameter("gname");
					//		��ѯ��Ʒ��Ϣ
					GoodsDaoImpl goodsDao=new GoodsDaoImpl();
					List<goodsmodel> goodslist = goodsDao.findGoodnameList(gname);
					//����Ʒ�б�ŵ���������
					request.setAttribute("goodslist", goodslist);
					request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
