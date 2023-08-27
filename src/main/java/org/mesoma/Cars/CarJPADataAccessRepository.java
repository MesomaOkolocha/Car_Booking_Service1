package org.mesoma.Cars;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("CarsJPA")
public class CarJPADataAccessRepository implements CarDaoInterface{

    private final CarsRepository carsRepository;

    public CarJPADataAccessRepository(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void registerCar(Car car) {
        carsRepository.save(car);
    }

    @Override
    public List<Car> getCars() {
        return carsRepository.findAll();
    }

    @Override
    public List<Car> getElectricCars() {
        return carsRepository.findByIsElectricTrue();
    }

    @Override
    public void deleteCarByRegNumber(String regNumber) {
        carsRepository.deleteCarByRegNumber(regNumber);
    }

    @Override
    public Optional<Car> getCarByRegNumber(String regNumber) {
        return carsRepository.findCarByRegNumber(regNumber);
    }

    @Override
    public boolean existsCarWithRegNumber(String regNumber) {
        return carsRepository.existsCarByRegNumber(regNumber);
    }
}
