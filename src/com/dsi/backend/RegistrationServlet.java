package com.dsi.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsi.backend.Dao.PasswordHashing;
import com.dsi.backend.Dao.QuerySomethingDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String showRomId = request.getParameter("show_room_id");
		String fullName = request.getParameter("full_name");
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		password = PasswordHashing.doMD5Hash(password);
		
		String query ="insert into users values(?,?,?,?)";
		int row = QuerySomethingDao.createUser(query , showRomId , fullName , userName,password);
		PrintWriter out = response.getWriter();
		if(row != 0) {
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('successfully created the user!');");
	        out.println("location='login.jsp';");
	        out.println("</script>");
			System.out.println("the user is created successfully!");
		}
		else {
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('failed tocreate the user!');");
	        out.println("location='login.jsp';");
	        out.println("</script>");
			System.out.println("The user is not created");
		}
		
//		response.sendRedirect("login.jsp");
	}

}
