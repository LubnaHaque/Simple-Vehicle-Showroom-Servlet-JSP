<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<body>

<form action="loginServlet" method="post">
    <input type="text" name="user_name" placeholder="Username" required="required"><br>
    <input type="password" name="password" placeholder="password" required="required"><br>
    <input type="submit" value="Login"><br>
    <label>not register?</label><a href="registration.jsp">Register here</a>
</form>

</body>
</html>
