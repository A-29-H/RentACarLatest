package com.example.rentacar.Entity;

public class Car {
    private String carName;
    private String carModel;
    private String carNumber;
    private int carRent;
    private int carId;

    public Car() {

    }



    public Car(String carName, String carModel, String carNumber, int carRent, int carId) {
        this.carName = carName;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carRent = carRent;
        this.carId = carId;
    }

    public Car(String carName, String carModel, String carNumber, int carRent) {
        this.carName = carName;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carRent = carRent;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarRent() {
        return carRent;
    }

    public void setCarRent(int carRent) {
        this.carRent = carRent;
    }
    @Override
    public String toString() {
        return getCarName()+" "+getCarNumber();
    }
}

