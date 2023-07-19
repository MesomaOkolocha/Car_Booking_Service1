package org.mesoma.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    //0 means added successfully, 1 means failure
    public void addNewCar(Car car){
        //check if car with same reg number already exists
        for(Car car1:carDAO.getCars()){
            if(car1.getRegNumber().equals(car.getRegNumber())){
                System.out.println(" Cars Can't have the same reg Number\n"+"Car "+ car1 +" already exists");
                return;
            }
        }
        //Set car to available then add it to the database
        car.setAvailable(true);
        carDAO.saveCar(car);
    }

    public List<Car> getCars(){
        return carDAO.getCars();
    }

    public List<Car> getElectricCars(){
        List<Car> cars = getCars();
        return cars.stream().filter(Car::isElectric).collect(Collectors.toList());
    }

}
