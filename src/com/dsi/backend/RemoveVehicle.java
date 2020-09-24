package com.dsi.backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsi.backend.Dao.QuerySomethingDao;

/**
 * Servlet implementation class RemoveVehicle
 */
@WebServlet("/removeVehicle")
public class RemoveVehicle extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userName = session.getAttribute("userName").toString();
		String modelNumber = request.getParameter("model_number");
		String query = "delete from trial_vehicle_table where user_name=? && model_number=?";
		
		int row = QuerySomethingDao.deleteVehicle(userName, modelNumber, query);
		
		System.out.println(row + " row(s) affected(removed)");
		response.sendRedirect("home.jsp");
	}

}
