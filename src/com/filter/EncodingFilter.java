package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.util.StringUtils;

/**
 *  java中extends是单继承，也就是一个java类只能继承一个类
 * 	而implements 是多个实现,也就是一个java可以实现多个接口
 * 	实现了某个接口后，该类要实现其未实现的方法,如果不实现，该类就要是 
 * 	抽象类(abstract class)或接口(interface,就是继承接口)
 * @author WOM
 *
 */
@WebFilter(filterName = "FilterDemo1",urlPatterns = "/*")
public class EncodingFilter implements Filter {
	
	private String encoding;

	/**
	 * 执行关闭流等操作
	 */
	public void destroy() {
		
	}
	/**
	 * 	在url-pattern中包含的所有请求都会执行此方法
	 * FilterChain对象，过滤链。多个过滤器组成一个过滤链。直到最后一个过滤器
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 设置请求的编码方式
		if(StringUtils.isEmpty(encoding)) {
			request.setCharacterEncoding("utf-8");
		}else {
			request.setCharacterEncoding(encoding);
		}
		//相应的编码格式
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}
	/**
	 * 初始化filter，只执行一次
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
//		filterConfig.getInitParameter(""); //初始化值
//		filterConfig.getInitParameterNames(); //初始化参数集合
		encoding = filterConfig.getInitParameter("encoding");
	}
	

}
