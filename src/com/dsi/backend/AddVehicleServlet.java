package com.dsi.backend;

import java.io.IOException;
import java.io.PrintWriter;

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
		String engineType = null;
		String turbo = "N/A";
		int weight = 0;
		switch (vehicleType) {
		case "normal":
			engineType = request.getParameter("engine_type");
			break;
		case "sports":
			turbo = request.getParameter("turbo");
			engineType = "oil";
			break;
		case "heavy":
			weight = Integer.parseInt(request.getParameter("weight"));
			engineType = "diesel";
			break;
		default:
			break;
		}
		int enginePower = Integer.parseInt(request.getParameter("engine_power"));
		int tireSize = Integer.parseInt(request.getParameter("tire_size"));
		
		
		System.out.println(modelNumber + " " + vehicleType + " " + engineType + " " + turbo + " " + weight + " " + enginePower + " " + tireSize);
		//call metohd
		String query = "insert into trial_vehicle_table2 values(?,?,?,?,?,?,?,?)";
		
		int count = QuerySomethingDao.insertData(query,userName, modelNumber, vehicleType, engineType, turbo, weight, enginePower, tireSize);
		System.out.println(count + " row(s) are affected(added)");
		PrintWriter out = response.getWriter();
		if(count != 0) {
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('added successfully!');");
	        out.println("location='home.jsp';");
	        out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('failed to add!');");
	        out.println("location='home.jsp';");
	        out.println("</script>");
		}
//		response.sendRedirect("home.jsp");
	}

}
