package com.dsi.backend.vehicle;

public class Vehicle {
	private String vehicleType;
	private String engineType;
	private String modelNumber;
	private String turbo;
	private int weight;
	private int enginePower;
	private int tireSize;
	public Vehicle(String vehicleType, String engineType, String modelNumber, String turbo, int weight, int enginePower,
			int tireSize) {
		this.vehicleType = vehicleType;
		this.engineType = engineType;
		this.modelNumber = modelNumber;
		this.turbo = turbo;
		this.weight = weight;
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
	public String getTurbo() {
		return turbo;
	}
	public void setTurbo(String turbo) {
		this.turbo = turbo;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
				+ ", turbo=" + turbo + ", weight=" + weight + ", enginePower=" + enginePower + ", tireSize=" + tireSize
				+ "]";
	}
	
	
	
	
	
}
