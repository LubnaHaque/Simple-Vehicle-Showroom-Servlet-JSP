
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
	//prevent to acces secure page
	DoPageSecure.dontGoSecurePageUsingBackButton(response);
	
	//prevent to access secure page if not login
	if(DoPageSecure.ifLogin(session) == false){
		response.sendRedirect("login.jsp");
	}
	else{
		String username = session.getAttribute("userName").toString();
		out.println("Welcome " + username);
	}
	
%>

<h2>Please choose your option: </h2>
<a href="addVehicle.jsp">Add Vehicle</a><br>
<a href="removeVehicle.jsp">Remove Vehicle</a><br>
<a href="showVehicleList">Show Vehicles</a>
<%@include file="logout.jsp" %>

</body>
</html>