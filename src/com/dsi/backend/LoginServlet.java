package com.dsi.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsi.backend.Dao.LoginDao;
import com.dsi.backend.Dao.MyConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Retrieve users' input
		String showRoomId = request.getParameter("show_room_id");
		String password = request.getParameter("password");
		
		
		if(LoginDao.isValidUser(showRoomId, password)) {
			//to do page secure
			HttpSession session = request.getSession();
			session.setAttribute("showRoomId", showRoomId);
			
			
			response.sendRedirect("home.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
