package org.mesoma.Cars;
//Pojo for cars class

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @SequenceGenerator(name = "customer_id_sequence",
            sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence")
    private Integer Id;
    @Column(nullable = false)
    private String regNumber;
    @Column(nullable = false)
    private double rentalPrice;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Column(nullable = false)
    private boolean isElectric;
    @Column(nullable = false)
    private boolean isAvailable;

    public Car() {
    }
    public Car(Integer id, String regNumber, double rentalPrice, Brand brand, boolean isElectric) {
        Id = id;
        this.regNumber = regNumber;
        this.rentalPrice = rentalPrice;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isAvailable = false;
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
