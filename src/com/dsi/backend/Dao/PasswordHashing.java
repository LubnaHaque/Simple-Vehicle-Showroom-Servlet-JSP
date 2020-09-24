package com.dsi.backend.Dao;

import java.security.MessageDigest;

public class PasswordHashing {
	
	public static String doMD5Hash(String password) {
		String hashedPassword = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			
			byte[] hashBytes = md.digest();
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<hashBytes.length;i++) {
				sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100 , 16).substring(1));
			}
			hashedPassword = sb.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return hashedPassword;
	}

}
