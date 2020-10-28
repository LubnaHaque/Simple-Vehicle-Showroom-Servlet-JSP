package com.dsi.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
//@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE" , discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {
    @Id
    @Column(name = "model_number")
    protected String modelNumber;
    @Column(name = "vehicle_type")
    protected String vehicleType;
    @Column(name = "engine_type")
    protected String engineType;
    @Column(name = "engine_power")
    protected int enginePower;
    @Column(name = "tire_size")
    protected int tireSize;
    @ManyToOne
    @JoinColumn(name = "owner" , referencedColumnName = "owner")
    protected LoginUser loginUser;

    public Vehicle() {

    }

    public Vehicle(String modelNumber, String vehicleType, String engineType, int enginePower, int tireSize) {
        this.modelNumber = modelNumber;
        this.vehicleType = vehicleType;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
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

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelNumber='" + modelNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower=" + enginePower +
                ", tireSize=" + tireSize +
                ", loginUser=" + loginUser +
                '}';
    }
}
