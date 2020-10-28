<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="registrationServlet" method="post">
    <input type="text" name="show_room_id" placeholder="show room ID" required="required"><br>
    <input type="text" name="full_name" placeholder="full name" required="required"><br>
    <input type="text" name="user_name" placeholder="user name" required="required"><br>
    <input type="password" name="password" placeholder="password" required="required"><br>
    <input type="submit" value="Sign in"><br>
    <label>already register?</label><a href="index.jsp">Login here</a>
</form>

</body>
</html>