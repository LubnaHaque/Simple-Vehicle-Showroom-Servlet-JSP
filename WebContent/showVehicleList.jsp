<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="com.dsi.backend.DoPageSecure"%>
<%@page import="com.dsi.backend.vehicle.Vehicle"%>
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
<h1>Vehicles List:</h1>

<%
ResultSet rs = (ResultSet) request.getAttribute("resultSet");
List<Vehicle> vehicles = new ArrayList<Vehicle>();
while(rs.next()){
	
	String vehicleType = rs.getString("vehicle_type");
	String engineType = rs.getString("engine_type");
	String modelNumber = rs.getString("model_number");
	int enginePower = Integer.parseInt(rs.getString("engine_power"));
	int tireSize = Integer.parseInt(rs.getString("tire_size"));
	
	Vehicle vehicle = new Vehicle(vehicleType,engineType,modelNumber,enginePower,tireSize);
	out.print(vehicle);
	%>
	<br>
	<%
}

%>
<%@include file="logout.jsp" %>
</body>
</html>