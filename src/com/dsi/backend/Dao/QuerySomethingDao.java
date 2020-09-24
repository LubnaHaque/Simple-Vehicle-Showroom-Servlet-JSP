package com.dsi.backend.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class QuerySomethingDao {
	
	String showRoomId;
	String modelNumber;
	String vehicleType;
	String engineType;
	int enginePower;
	int tireSize;
	
	public void passData(String showRoomId2,String modelNumber2,String vehicleType2,String engineType2, int enginePower2,int tireSize2) {
		showRoomId = showRoomId2;
		modelNumber = modelNumber2;
		vehicleType = vehicleType2;
		engineType= engineType2;
		enginePower = enginePower2;
		tireSize = tireSize2;
	}
	
	public void passData(String showRoomId2) {
		showRoomId = showRoomId2;
	}
	
	public int insertData(String query) {
		Connection con = MyConnection.getConnection();
		int affectedRow = 0;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			pst.setString(2, modelNumber);
			pst.setString(3, vehicleType);
			pst.setString(4, engineType);
			pst.setInt(5, enginePower);
			pst.setInt(6, tireSize);
			
			affectedRow = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRow;
	}
	
	public ResultSet vehicleList(String query) {
		ResultSet rs =null;
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			rs = pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int deleteVehicle(String showRoomId , String modelNumber , String query) {
		int row = 0;
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, showRoomId);
			pst.setString(2, modelNumber);
			
			row = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public int createUser(String query , String showRoomId,String fullName,String userName,String password) {
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
			e.printStackTrace();
		}
		
		return row;
	}
}
