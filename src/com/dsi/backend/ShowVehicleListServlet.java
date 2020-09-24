package com.dsi.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsi.backend.Dao.QuerySomethingDao;

/**
 * Servlet implementation class ShowVehicleListServlet
 */
@WebServlet("/showVehicleList")
public class ShowVehicleListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String showRoomId = session.getAttribute("showRoomId").toString();
		String query = "select* from trial_vehicle_table where show_room_id = ?";
		
		QuerySomethingDao giveSomething = new QuerySomethingDao();
		giveSomething.passData(showRoomId);
		ResultSet rs = giveSomething.vehicleList(query);
		
		RequestDispatcher rd = request.getRequestDispatcher("showVehicleList.jsp");
		request.setAttribute("resultSet", rs);
		rd.forward(request, response);
	}

}
