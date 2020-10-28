<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h2>Give the vehicle's model number which one you want to remove: </h2>
<form action="removeVehicleServlet" method="post">
    <input type="text" name="model_number" placeholder="model number" required="required"><br>
    <input type="submit"><br>

    <label>forgot model number?</label><a href="showVehicle.jsp">see here</a>
</form>
<%@include file="logout.jsp" %>
</body>
</html>