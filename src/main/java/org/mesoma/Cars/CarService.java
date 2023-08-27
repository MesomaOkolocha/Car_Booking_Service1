package org.mesoma.Cars;

import org.mesoma.utils.DuplicateResourceException;
import org.mesoma.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarService {
    private final CarDaoInterface carDaoInterface;

    public CarService(@Qualifier("CarsJPA")CarDaoInterface carDaoInterface) {
        this.carDaoInterface = carDaoInterface;
    }

    //0 means added successfully, 1 means failure
    @Transactional
    public void addNewCar(Car car){
        //check if car with same reg number already exists
        for(Car car1:carDaoInterface.getCars()){
            if(car1.getRegNumber().equals(car.getRegNumber())){
                System.out.println(" Cars Can't have the same reg Number\n"+"Car "+ car1 +" already exists");
                return;
            }
        }
        //Set car to available then add it to the database
        car.setAvailable(true);
        carDaoInterface.registerCar(car);
    }

    public List<Car> getCars(){
        return carDaoInterface.getCars();
    }

    public List<Car> getElectricCars(){
        return carDaoInterface.getElectricCars();
    }
    @Transactional
    public void registerCar(CarRegistrationRequest carRegistrationRequest){
        //check if car with regNumber exists
        if(carDaoInterface.existsCarWithRegNumber(carRegistrationRequest.regNumber())){
            throw new DuplicateResourceException("Car with Reg Number already exists");
        }
        Car car = new Car(carRegistrationRequest.regNumber(), carRegistrationRequest.rentalPrice(),
                carRegistrationRequest.brand(), carRegistrationRequest.isElectric());
        car.setAvailable(true);
        carDaoInterface.registerCar(car);
    }
    @Transactional
    public void deleteCarByRegNumber(String regNumber){
        //check if car with regNumber exists
        if(!carDaoInterface.existsCarWithRegNumber(regNumber)){
            throw new DuplicateResourceException("no such car with given regNumber");
        }
        carDaoInterface.deleteCarByRegNumber(regNumber);
    }

    public Car getCarByRegNumber(String regNumber){
        return carDaoInterface.getCarByRegNumber(regNumber).orElseThrow
                (() -> new ResourceNotFoundException(
                "car with regNumber [%s] not found".formatted(regNumber)
        ));
    }

}
