package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
/**
 * @category ��֤��������
 * 
 * @author WOM
 *
 */
	@WebServlet(urlPatterns = "/captcha")
	public class CaptchaServlet extends HttpServlet{


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    // ���ÿ��ߡ�λ��
		
		
		//        CaptchaUtil.out(120, 38, 5, req, resp);
		        // ʹ��gif��֤��
		        GifCaptcha gifCaptcha = new GifCaptcha(120,38,4);
		        CaptchaUtil.out(gifCaptcha, req, resp);
			}

		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}


	}