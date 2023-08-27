package org.mesoma.Cars;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("CarListDao")
public class CarListDataAccessRepository implements CarDaoInterface {
    private final static List<Car> cars;

    static{
        cars = new ArrayList<>();
    }

    public void registerCar(Car car){
        cars.add(car);
    }

    public List<Car> getCars(){
        return cars;
    }

    @Override
    public List<Car> getElectricCars() {
        return cars.stream().filter(Car::isElectric).toList();
    }

    @Override
    public void deleteCarByRegNumber(String regNumber) {
        cars.stream().filter(car -> car.getRegNumber().equals(regNumber)).
                findFirst().ifPresent(cars::remove);
    }

    @Override
    public Optional<Car> getCarByRegNumber(String regNumber) {
        return cars.stream().filter(car -> car.getRegNumber().equals(regNumber)).
                findFirst();
    }

    @Override
    public boolean existsCarWithRegNumber(String regNumber) {
        return cars.stream().anyMatch(car -> car.getRegNumber().equals(regNumber));
    }
}
