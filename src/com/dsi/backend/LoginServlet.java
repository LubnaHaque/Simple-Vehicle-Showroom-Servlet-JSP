package com.dsi.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsi.backend.Dao.MyConnection;
import com.dsi.backend.Dao.PasswordHashing;
import com.dsi.backend.Dao.QuerySomethingDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Retrieve users' input
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		password = PasswordHashing.doMD5Hash(password);
		String query = "select * from users where user_name = ? && password = ?";
		
		if(QuerySomethingDao.isValidUser(query ,userName, password)) {
			//to do page secure
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			
			System.out.println("login successfully!");
			response.sendRedirect("home.jsp");
		}
		else {
			System.out.println("login failed!");
			response.sendRedirect("login.jsp");
		}
	}

}
