package com.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.model.goodsmodel;
import com.util.StringUtils;

@WebServlet("/check.action")
public class CheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        
	    	HttpSession session = request.getSession();
	    	Object user= session.getAttribute("user");
		
			if(user==null && StringUtils.isEmpty((String)user)) {
				String from=request.getParameter("from");
				//System.out.println("login"+user);
	            String message="请先登录,再购物！";
	            request.setAttribute("message", message);
	           
				
				
				/* window.location.href='goodslist.action'; */
				 
				

	            request.getRequestDispatcher("goodslist.action").forward(request, response);
				return;
			}


        /**
         * 接收json
         */
        BufferedReader reader = request.getReader();
        String json = reader.readLine();
        json = json.substring(0, json.indexOf("&cmd=_cart"));
   		System.out.println(json);
   		String encodeURL=URLDecoder.decode( json, "UTF-8" );    
   		String[] jsonstring=encodeURL.split("\\&");
		List<goodsmodel> list = new ArrayList<goodsmodel>();
        for(int i=0;i<jsonstring.length/5;i++) {
        	goodsmodel goods;
        	
        		String[] tempid=jsonstring[5*i+3].split("=");
        		String[] tempname=jsonstring[5*i+1].split("=");
        		String[] tempimg=jsonstring[5*i+4].split("=");
        		String[] tempprice=jsonstring[5*i+2].split("=");
        		String[] tempintro=jsonstring[5*i].split("=");
//        		System.out.println(tempid[1]);
//        		System.out.println(tempname[1]);
//        		System.out.println(tempimg[1]);
//        		System.out.println(tempprice[1]);
//        		
//        		System.out.println(tempintro[1]);
        		goods = new goodsmodel(Integer.parseInt(tempid[1]),tempname[1],tempimg[1],Double.parseDouble(tempprice[1]),Integer.parseInt(tempintro[1])); 
        		
        		list.add(goods);
        	
        	
        	
        }
        
        request.setAttribute("goodslist", list);
        
       
        reader.close();

       

    	request.getRequestDispatcher("checkout.jsp").forward(request, response);
		
	}
	@Test
	public void stest() throws UnsupportedEncodingException {
		String json="quantity_1=3&googles_item_1=AVSEN+%E9%9C%8D%E5%A4%AB%E6%A3%AE&amount_1=29.9&shipping_1=1&shipping2_1=images%2F1.webp&quantity_2=2&googles_item_2=%E5%A1%94%E5%85%B0%E5%A4%9A+%2F+ADDE+%E9%98%BF%E5%BE%B7&amount_2=535&shipping_2=2&shipping2_2=images%2F2.webp&quantity_3=2&googles_item_3=GO+%E8%8B%B1%E6%A0%BC+%2F+IVAR+%E4%BC%8A%E5%A8%83&amount_3=915&shipping_3=6&shipping2_3=images%2F6.webp&quantity_4=1&googles_item_4=KEDALEN+%E4%BC%8A%E5%85%8B%E5%A4%9A%E5%85%B0+%2F+EKEDALEN+%E4%BC%8A%E5%85%8B%E5%A4%9A%E5%85%B0&amount_4=2896&shipping_4=7&shipping2_4=images%2F7.webp&cmd=_cart&upload=1&bn=sbmincart_AddToCart_WPS_US";
		 json = json.substring(0, json.indexOf("&cmd=_cart"));
		System.out.println(json);
		String encodeURL=URLDecoder.decode( json, "UTF-8" );    
		String[] jsonstring=encodeURL.split("\\&");
		
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		//String[] jsons=jsonstring
			
	        for(String i:jsonstring) {
	        	
	        	i = new String (i.getBytes("UTF-8"),"UTF-8");
	        	
			/*
			 * while (result.next()) { goodsmodel goods = ; list.add(goods); }
			 */
	        	//System.out.println(i);
	        	
	        	
	        }
	        for(int i=0;i<jsonstring.length/5;i++) {
	        	goodsmodel goods;
	        	
	        		String[] tempid=jsonstring[5*i+3].split("=");
	        		String[] tempname=jsonstring[5*i+1].split("=");
	        		String[] tempimg=jsonstring[5*i+4].split("=");
	        		String[] tempprice=jsonstring[5*i+2].split("=");
	        		String[] tempintro=jsonstring[5*i].split("=");
	        		System.out.println(tempid[1]);
	        		System.out.println(tempname[1]);
	        		System.out.println(tempimg[1]);
	        		System.out.println(tempprice[1]);
	        		
	        		System.out.println(tempintro[1]);
	        		goods = new goodsmodel(Integer.parseInt(tempid[1]),tempname[1],tempimg[1],Double.parseDouble(tempprice[1]),Integer.parseInt(tempintro[1])); 
	        		
	        		list.add(goods);
	        	
	        
	        	
	        }
	        System.out.println(list);

		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
