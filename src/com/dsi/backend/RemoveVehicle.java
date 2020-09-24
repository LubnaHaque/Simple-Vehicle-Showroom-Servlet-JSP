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
		String showRoomId = session.getAttribute("showRoomId").toString();
		String modelNuber = request.getParameter("model_number");
		String query = "delete from trial_vehicle_table where show_room_id=? && model_number=?";
		
		QuerySomethingDao delete = new QuerySomethingDao();
		int row = delete.deleteVehicle(showRoomId, modelNuber, query);
		
		System.out.println(row + " row(s) affected.");
		response.sendRedirect("home.jsp");
	}

}
