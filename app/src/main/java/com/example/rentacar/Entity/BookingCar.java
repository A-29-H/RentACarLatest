package com.example.rentacar.Entity;

public class BookingCar {
    private String carName;
    private String carModel;
    private String carNumber;
    private int carRent;
    private String userName;
    private int days;
    private int accNo;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingCar() {
    }

    public BookingCar(String carName, String carModel, String carNumber, int carRent, String userName, int days, int accNo,String status) {
        this.carName = carName;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carRent = carRent;
        this.userName = userName;
        this.days = days;
        this.accNo = accNo;
        this.status = status;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
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

        return getCarName()+" "+getDays()+" "+getStatus();
    }
}
