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
 * @category ��Ʒ��ϸ��תaction
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
		//		��ȡ��ƷID
		int goodsid = Integer.valueOf(request.getParameter("goodsid"));
		request.setAttribute("do", request.getParameter("do"));
		
		//		��ѯ��Ʒ��Ϣ
		GoodsDaoImpl goodsDao=new GoodsDaoImpl();
		goodsmodel goods= goodsDao.find(goodsid);
		//		����seesion������
		request.setAttribute("goods", goods);
		

		//		��ת����Ϣ�������
		request.getRequestDispatcher("reviews.action").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
