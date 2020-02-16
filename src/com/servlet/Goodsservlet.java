package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDaoImpl;
import com.model.goodsmodel;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Goodsservlet
 */
@WebServlet("/goodsservlet")
public class Goodsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Goodsservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     PrintWriter out=response.getWriter();
	        org.json.JSONObject jsonObject=new org.json.JSONObject();
	        jsonObject.put("code",0);
	        jsonObject.put("msg","");
	        jsonObject.put("count",1);
	        String sql="select * from user";
	        JSONArray result=null;
	        GoodsDaoImpl users=new GoodsDaoImpl();
	        System.out.println(users.findGoodList());
			result = JSONArray.fromObject(users.findGoodList());
	        jsonObject.put("data",result);
	        System.out.println(jsonObject.toString());
	        out.println(jsonObject.toString());
	        out.flush();
	        out.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
