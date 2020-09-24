package com.dsi.backend.vehicle;

public class HeavyVehicle extends Vehicle{
	private int weight;

	
	
	public HeavyVehicle(String vehicleType, String engineType, String modelNumber, int enginePower, int tireSize,
			int weight) {
		super(vehicleType, engineType, modelNumber, enginePower, tireSize);
		this.weight = weight;
//		this.setEngineType("disel");
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

}
