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

<h2>Give Vehicle's Info</h2>
<form action="addVehicle" method="post">
	<input type="text" name="model" required="required" placeholder="model number"><br>
	
	<select name="vehicle_type" required="required">
		<option value="">Choose vehicle type</option>
		<option value="normal">Normal</option>
		<option value="sports">Sports</option>
		<option value="heavy">Heavy</option>
	</select><br>
	
	<select name="engine_type" required="required">
		<option value="">choose engine type</option>
		<option value="oil">Oil</option>
		<option value="diesel">Diesel</option>
		<option value="gas">Gas</option>
	
	</select><br>
	
	<input type="number" name="engine_power" onkeypress="return event.charCode >= 48" min="1"" placeholder="engine power" required="required"><br>
	
	<input type="number" name="tire_size" onkeypress="return event.charCode >= 48" min="1"" placeholder="tire size" required="required"><br>
	
	<input type="submit">
</form>


<%@include file="logout.jsp" %>
</body>
</html>