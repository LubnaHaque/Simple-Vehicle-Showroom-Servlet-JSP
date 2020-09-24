package com.dsi.backend.vehicle;


public class SportsVehicle extends Vehicle{
	private boolean turbo;

	public SportsVehicle(String vehicleType, String engineType, String modelNumber, int enginePower, int tireSize,
			boolean turbo) {
		super(vehicleType, engineType, modelNumber, enginePower, tireSize);
		this.turbo = turbo;
//		this.setEngineType("oil");
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	

}
