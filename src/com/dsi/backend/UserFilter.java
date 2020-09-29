package com.dsi.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/registration")
public class UserFilter implements Filter {
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		
		if((userName.length() >= 3 && userName.length() <= 10) && password.length() >= 3) {
			chain.doFilter(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('username or password length is greater or less! it should be between 3 to 10');");
	        out.println("location='registration.jsp';");
	        out.println("</script>");
//			res.sendRedirect("registration.jsp");
			System.out.println("username or password's length is greater or less!");
			System.out.println("it should be between 3 to 10");
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
