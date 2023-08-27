package org.mesoma.Cars;

import java.util.List;
import java.util.Optional;

public interface CarDaoInterface {
    void registerCar(Car car);

    List<Car> getCars();
    List<Car> getElectricCars();

    void deleteCarByRegNumber(String regNumber);

    Optional<Car> getCarByRegNumber(String regNumber);

    boolean existsCarWithRegNumber(String regNumber);

}
