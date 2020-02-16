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
/**
 * @category 商品列表控制器
 * @author WOM
 *
 */
@WebServlet(urlPatterns = { "/goodslist.action" }, loadOnStartup=0)
public class GoodslistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodslistAction() {
        super();
    }
    @Override
    	public void init() throws ServletException {
    		// TODO Auto-generated method stub
    		super.init();
    		System.out.println("list");
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//创建数据访问对象
		GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		List<goodsmodel> list = goodsDao.findGoodList();
		//将商品列表放到作用域当中
		request.setAttribute("goodslist", list);
	//	request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
