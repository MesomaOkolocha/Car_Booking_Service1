package org.mesoma.Cars;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarDAO implements CarDaoInterface {
    private final static List<Car> cars;

    static{
        cars = new ArrayList<>();
    }

    public void saveCar(Car car){
        cars.add(car);
    }

    public List<Car> getCars(){
        return cars;
    }
}
