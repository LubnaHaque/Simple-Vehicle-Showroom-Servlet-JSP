package com.dsi.servlets;

import com.dsi.model.HibernateUtil;
import com.dsi.model.ShowRoomOwner;
import com.dsi.security.HashingUtill;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("registration servlet visited");

        String showRoomId = req.getParameter("show_room_id");
        String fullName = req.getParameter("full_name");
        String userName = req.getParameter("user_name");
        String password = req.getParameter("password");

        password = HashingUtill.doMD5Hash(password);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ShowRoomOwner user = new ShowRoomOwner();
        user.setFullName(fullName);
        user.setPassword(password);
        user.setShowRoomId(showRoomId);
        user.setUserName(userName);
        try {
            session.save(user);
            resp.sendRedirect("index.jsp");
        } catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("registration.jsp");
        }

        session.getTransaction().commit();
//        HibernateUtil.shutdown();
    }
}
