package com.dsi.backend.vehicle;

public class Vehicle {
	private String vehicleType;
	private String engineType;
	private String modelNumber;
	private int enginePower;
	private int tireSize;
	
	public Vehicle(String vehicleType, String engineType, String modelNumber, int enginePower, int tireSize) {

		this.vehicleType = vehicleType;
		this.engineType = engineType;
		this.modelNumber = modelNumber;
		this.enginePower = enginePower;
		this.tireSize = tireSize;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public int getTireSize() {
		return tireSize;
	}

	public void setTireSize(int tireSize) {
		this.tireSize = tireSize;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", engineType=" + engineType + ", modelNumber=" + modelNumber
				+ ", enginePower=" + enginePower + ", tireSize=" + tireSize + "]";
	}
	
	
	
}
