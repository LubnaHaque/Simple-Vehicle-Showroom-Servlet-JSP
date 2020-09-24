<%@page import="com.dsi.backend.DoPageSecure"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(DoPageSecure.ifLogin(session) == true){
	response.sendRedirect("home.jsp");
}
%>
<form action="login" method="post">
	<input type="text" name="user_name" placeholder="Username" required="required"><br>
	<input type="password" name="password" placeholder="password" required="required"><br>
	<input type="submit" value="Login"><br>
	<label>not register?</label><a href="registration.jsp">Register here</a>
</form>

</body>
</html>