package com.dsi.backend.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class QuerySomethingDao {
	
	public static boolean isValidUser(String query , String userName , String password) {
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
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
	
	public static int insertData(String query,String userName,String modelNumber,String vehicleType,String engineType, String turbo, int weight, int enginePower,int tireSize) {
		Connection con = MyConnection.getConnection();
		int affectedRow = 0;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, modelNumber);
			pst.setString(3, vehicleType);
			pst.setString(4, engineType);
			pst.setString(5, turbo);
			pst.setInt(6, weight);
			pst.setInt(7, enginePower);
			pst.setInt(8, tireSize);
			
			affectedRow = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return affectedRow;
	}
	
	public static ResultSet vehicleList(String query,String userName) {
		ResultSet rs =null;
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			rs = pst.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rs;
	}
	
	public static int deleteVehicle(String userName , String modelNumber , String query) {
		int row = 0;
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, modelNumber);
			
			row = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static int createUser(String query , String showRoomId,String fullName,String userName,String password) {
		Connection con = MyConnection.getConnection();
		int row = 0;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			pst.setString(2, fullName);
			pst.setString(3, userName);
			pst.setString(4, password);
			
			row = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return row;
	}
}
