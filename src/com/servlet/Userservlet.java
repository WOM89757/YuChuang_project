package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dao.userdao;
import com.model.usermodel;

import net.sf.json.JSONArray;

@WebServlet("/userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Userservlet() {
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
	        userdao users=new userdao();

			try {
				System.out.println(users.userlist(sql));
				result = JSONArray.fromObject( users.userlist(sql));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        jsonObject.put("data",result);
	        System.out.println(jsonObject.toString());
	        out.println(jsonObject.toString());
	        out.flush();
	        out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
