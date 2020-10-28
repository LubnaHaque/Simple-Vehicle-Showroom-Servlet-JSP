package com.dsi.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/registrationServlet")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("visited filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String userName =request.getParameter("user_name");
        String password = request.getParameter("password");
        if(userName.length() >= 3 && password.length() >= 3){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            System.out.println("username or password's length is greater or less!");
            System.out.println("it should be between 3 to 10");
            response.sendRedirect("registration.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
