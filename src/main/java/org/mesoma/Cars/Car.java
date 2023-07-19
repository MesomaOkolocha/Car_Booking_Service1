package org.mesoma.Cars;
//Pojo for cars class

import java.util.Objects;

public class Car {
    private String regNumber;
    private double rentalPrice;
    private Brand brand;
    private boolean isElectric;
    private boolean isAvailable;

    public Car() {
    }

    public Car(String regNumber, double rentalPrice, Brand brand, boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPrice = rentalPrice;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isAvailable = false;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.rentalPrice, rentalPrice) == 0 && isElectric == car.isElectric && Objects.equals(regNumber, car.regNumber) && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, rentalPrice, brand, isElectric);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
