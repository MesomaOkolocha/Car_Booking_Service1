package org.mesoma.Bookings;

import org.mesoma.Cars.CarService;
import org.mesoma.Cars.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBookingService {
    private final CarBookingDaoInterface carBookingDaoInterface;
    private final CarService carService;

    public CarBookingService(CarBookingDaoInterface carBookingDaoInterface, CarService carService) {
        this.carBookingDaoInterface = carBookingDaoInterface;
        this.carService = carService;
    }

    //method to view all available cars in rental
    public List<Car> getAllCars(){
        return carService.getCars();
    }

    public List<Car> getAllElectricCars(){
        return carService.getElectricCars();
    }

    public List<CarBooking> getBookings(){
        return (carBookingDaoInterface.getBookings());
    }

    //save booking to database
    public void saveBookingToDAO(CarBooking booking){
        carBookingDaoInterface.saveBooking(booking);
    }

}
