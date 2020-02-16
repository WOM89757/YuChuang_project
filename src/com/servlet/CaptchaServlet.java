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
 * @category 验证码生成器
 * 
 * @author WOM
 *
 */
	@WebServlet(urlPatterns = "/captcha")
	public class CaptchaServlet extends HttpServlet{


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    // 设置宽、高、位数
		
		
		//        CaptchaUtil.out(120, 38, 5, req, resp);
		        // 使用gif验证码
		        GifCaptcha gifCaptcha = new GifCaptcha(120,38,4);
		        CaptchaUtil.out(gifCaptcha, req, resp);
			}

		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}


	}