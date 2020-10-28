package com.dsi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(name = "modelNumber")
@DiscriminatorValue("Heavy")
public class HeavyVehicle extends Vehicle{
    private int weight;

    public HeavyVehicle() {
    }

    public HeavyVehicle(String modelNumber, String vehicleType, String engineType, int enginePower, int tireSize, int weight) {
        super(modelNumber, vehicleType, engineType, enginePower, tireSize);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeavyVehicle{" +
                "weight=" + weight +
                ", modelNumber='" + modelNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower=" + enginePower +
                ", tireSize=" + tireSize +
                ", loginUser=" + loginUser +
                '}';
    }
}
