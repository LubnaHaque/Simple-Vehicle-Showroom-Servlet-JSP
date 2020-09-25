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
	DoPageSecure.dontGoSecurePageUsingBackButton(response);
	if(DoPageSecure.ifLogin(session) == false){
		response.sendRedirect("login.jsp");
	}
%>

<h2>Give the vehicle's model number which one you want to remove: </h2>
<form action="removeVehicle">
	<input type="text" name="model_number" placeholder="model number" required="required"><br>
	<input type="submit">
	
	<label>forgot model number?</label><a href="showVehicleList">see here</a>
</form>
<%@include file="logout.jsp" %>
</body>
</html>