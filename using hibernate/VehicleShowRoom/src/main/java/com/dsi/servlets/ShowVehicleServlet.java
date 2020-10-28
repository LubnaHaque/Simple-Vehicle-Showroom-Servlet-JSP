package com.dsi.servlets;

import com.dsi.model.HibernateUtil;
import com.dsi.model.LoginUser;
import com.dsi.model.Vehicle;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/showVehicleServlet")
public class ShowVehicleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("show servlet visited");
        HttpSession httpSession = req.getSession();
        String owner = httpSession.getAttribute("username").toString();
        LoginUser temp = new LoginUser();
        temp.setUserName(owner);

        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Vehicle v where v.loginUser=:ownerPara");
        query.setParameter("ownerPara" , temp);
        List<Vehicle> vehicles = query.list();
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        session.getTransaction().commit();
    }
}
