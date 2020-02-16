<%@page import="java.sql.ResultSet"%>
<%@page import="com.db.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<%
	//Thread.currentThread().sleep(5000);
	String username = request.getParameter("username");
	DBHelper db = new DBHelper();
    String sql = "select * from user where username = ?";
	ResultSet result = db.executeQuery(sql, username);
  	if(result.next()) {
  		%><span class="reg_iconw" ><%out.println("该用户名已经存在");%></span><%
   	}else{
   		%><span class="reg_icons" ><%out.println("");%></span><%
   	}
%>

</body>
</html>