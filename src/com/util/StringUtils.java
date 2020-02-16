package com.util;


/**
 * @category 字符串工具类
 * @author WOM
 *
 */
  public class StringUtils {

	  /**
	
	  - 判断字符串是否为空
	  - 包括空串
	  - @param str 
	  - @return true表示空
	    */
	    public static boolean isEmpty(String str) {
	    return str == null || "".equals(str.trim());
	    }
	
	  /**
	
	  - 判断字符串是否不为空
	  - 包括空串
	  - @param str 
	  - @return true表示非空
	    */
	    public static boolean isNotEmpty(String str) {
	    return str != null || !"".equals(str.trim());
	    }
	
	  /**
	
	  - 判断有效字符串(去掉首尾空格后)的长度是否满足要求
	  - @param str 字符串
	  - @param length 长度要求
	  - @return true表示满足,当str为空时返回false
	    */
	    public static boolean isEqLength(String str, int length) {
	    if(isNotEmpty(str)) {
	    	return str.trim().length() >= length;
	    }else {
	    	return false;
	    }
	    }
    }