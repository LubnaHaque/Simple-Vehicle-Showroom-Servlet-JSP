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
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch values
		HttpSession session = request.getSession();
		String userName = session.getAttribute("userName").toString();
		String modelNumber = request.getParameter("model");
		String vehicleType = request.getParameter("vehicle_type");
		String engineType = request.getParameter("engine_type");
		int enginePower = Integer.parseInt(request.getParameter("engine_power"));
		int tireSize = Integer.parseInt(request.getParameter("tire_size"));
		
		//call metohd
		String query = "insert into trial_vehicle_table values(?,?,?,?,?,?)";
		
		int count = QuerySomethingDao.insertData(query,userName, modelNumber, vehicleType, engineType, enginePower, tireSize);
		System.out.println(count + " row(s) are affected(added)");
		
		response.sendRedirect("home.jsp");
	}

}
