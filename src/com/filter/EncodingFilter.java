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
 *  java��extends�ǵ��̳У�Ҳ����һ��java��ֻ�ܼ̳�һ����
 * 	��implements �Ƕ��ʵ��,Ҳ����һ��java����ʵ�ֶ���ӿ�
 * 	ʵ����ĳ���ӿں󣬸���Ҫʵ����δʵ�ֵķ���,�����ʵ�֣������Ҫ�� 
 * 	������(abstract class)��ӿ�(interface,���Ǽ̳нӿ�)
 * @author WOM
 *
 */
@WebFilter(filterName = "FilterDemo1",urlPatterns = "/*")
public class EncodingFilter implements Filter {
	
	private String encoding;

	/**
	 * ִ�йر����Ȳ���
	 */
	public void destroy() {
		
	}
	/**
	 * 	��url-pattern�а������������󶼻�ִ�д˷���
	 * FilterChain���󣬹�������������������һ����������ֱ�����һ��������
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// ��������ı��뷽ʽ
		if(StringUtils.isEmpty(encoding)) {
			request.setCharacterEncoding("utf-8");
		}else {
			request.setCharacterEncoding(encoding);
		}
		//��Ӧ�ı����ʽ
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}
	/**
	 * ��ʼ��filter��ִֻ��һ��
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
//		filterConfig.getInitParameter(""); //��ʼ��ֵ
//		filterConfig.getInitParameterNames(); //��ʼ����������
		encoding = filterConfig.getInitParameter("encoding");
	}
	

}
