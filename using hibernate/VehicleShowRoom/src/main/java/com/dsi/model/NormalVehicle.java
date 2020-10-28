package com.dsi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(name = "modelNumber")
@DiscriminatorValue("Normal")
public class NormalVehicle extends Vehicle {

    public NormalVehicle(String modelNumber, String vehicleType, String engineType, int enginePower, int tireSize) {
        super(modelNumber, vehicleType, engineType, enginePower, tireSize);
    }

    public NormalVehicle() {
    }

    @Override
    public String toString() {
        return "NormalVehicle{" +
                "modelNumber='" + modelNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower=" + enginePower +
                ", tireSize=" + tireSize +
                ", loginUser=" + loginUser +
                '}';
    }
}
