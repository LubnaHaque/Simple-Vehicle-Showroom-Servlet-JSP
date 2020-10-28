package com.dsi.servlets;

import com.dsi.model.HibernateUtil;
import com.dsi.model.Vehicle;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/removeVehicleServlet")
public class RemoveVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove servlet visited");
        String modelNumber = req.getParameter("model_number");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Vehicle vehicle = session.get(Vehicle.class , modelNumber);
        try{
            session.delete(vehicle);
            System.out.println("deleted the vehicle!");
            resp.sendRedirect("removeVehicle.jsp");
        } catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("removeVehicle.jsp");
        }

        session.getTransaction().commit();
    }
}
