package com.dsi.backend;

import java.io.IOException;
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
		if(row != 0) {
			System.out.println("the user is created successfully!");
		}
		else {
			System.out.println("The user is not created");
		}
		
		response.sendRedirect("login.jsp");
	}

}
