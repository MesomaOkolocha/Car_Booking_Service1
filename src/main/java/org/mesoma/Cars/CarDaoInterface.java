package org.mesoma.Cars;

import java.util.List;

public interface CarDaoInterface {
    void saveCar(Car car);

    List<Car> getCars();
}
