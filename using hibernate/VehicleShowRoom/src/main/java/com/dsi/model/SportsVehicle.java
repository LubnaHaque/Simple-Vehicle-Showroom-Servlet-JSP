package com.dsi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(name = "modelNumber")
@DiscriminatorValue("Sports")
public class SportsVehicle extends Vehicle{
    private String turbo;

    public SportsVehicle() {
    }

    public SportsVehicle(String modelNumber, String vehicleType, String engineType, int enginePower, int tireSize, String turbo) {
        super(modelNumber, vehicleType, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }

    public String isTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "SportsVehicle{" +
                "turbo='" + turbo + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower=" + enginePower +
                ", tireSize=" + tireSize +
                ", loginUser=" + loginUser +
                '}';
    }
}
