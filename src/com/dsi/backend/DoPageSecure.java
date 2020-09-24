package com.dsi.backend;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoPageSecure {
	
	public static boolean ifLogin(HttpSession session) {
		if(session.getAttribute("userName") == null){
			return false;
		}
		return true;
	}
	
	public static void dontGoSecurePageUsingBackButton(HttpServletResponse response) {
		
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	}

}
