package com.dsi.backend.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	
	public static boolean isValidUser(String showRoomId , String password) {
		Connection con = MyConnection.getConnection();
		String query = "select * from users where show_room_id = ? && password = ?";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static String getUserName(String showRoomId) {
		Connection con = MyConnection.getConnection();
		String query = "select * from users where show_room_id = ?";
		String username  = null;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			ResultSet rs = pst.executeQuery();
			rs.next();
			username = rs.getString(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return username;
	}

}
