package com.dsi.servlets;

import com.dsi.model.*;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/addVehicleServlet")
public class AddVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add servlet visited");

        HttpSession httpSession = req.getSession();
        String username = httpSession.getAttribute("username").toString();
        LoginUser loginUser = new LoginUser();
        loginUser.setUserName(username);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String modelNumber = req.getParameter("model_number");
        int enginePower = Integer.parseInt(req.getParameter("engine_power"));
        int tireSize = Integer.parseInt(req.getParameter("tire_size"));
        String vehicleType = req.getParameter("vehicle_type");

        String engineType = null;
        String turbo = null;
        int weight = -1;

        Vehicle vehicle = null;
        switch (vehicleType){
            case "normal" :
                engineType= req.getParameter("engine_type");
                vehicle = new NormalVehicle(modelNumber,vehicleType,engineType,enginePower,tireSize);
                break;
            case "sports" :
                engineType = "oil";
                turbo = req.getParameter("turbo");
                vehicle = new SportsVehicle(modelNumber,vehicleType,engineType,enginePower,tireSize,turbo);
                break;
            case "heavy" :
                engineType="diesel";
                weight= Integer.parseInt(req.getParameter("weight"));
                vehicle = new HeavyVehicle(modelNumber,vehicleType,engineType,enginePower,tireSize,weight);
                break;
            default:
                break;
        }

        if (vehicle != null) {
            vehicle.setLoginUser(loginUser);
        }
        try {
            LoginUser temp = session.get(LoginUser.class , username);
            if(temp == null)
                session.save(loginUser);
            session.save(vehicle);
            session.getTransaction().commit();
            resp.sendRedirect("home.jsp");
        } catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("addVehicle.jsp");
        }
//        session.save(loginUser);
//        session.save(vehicle);
//        session.getTransaction().commit();
//        resp.sendRedirect("home.jsp");



    }

}
