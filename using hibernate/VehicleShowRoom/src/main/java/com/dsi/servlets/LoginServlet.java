package com.dsi.servlets;


import com.dsi.model.HibernateUtil;
import com.dsi.model.ShowRoomOwner;
import com.dsi.security.HashingUtill;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login servlet visited");
        String userName = req.getParameter("user_name");
        String password = req.getParameter("password");
        password = HashingUtill.doMD5Hash(password);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ShowRoomOwner user = session.get(ShowRoomOwner.class , userName);
        if(user == null){
            System.out.println("user doesn't exits");
            resp.sendRedirect("index.jsp");
        }
        else if(password.equals(user.getPassword())){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username" , userName);
            System.out.println("login success!");
            resp.sendRedirect("home.jsp");
        }
        else{
            System.out.println("password is incorrect!");
            resp.sendRedirect("index.jsp");
        }

        session.getTransaction().commit();
    }
}
