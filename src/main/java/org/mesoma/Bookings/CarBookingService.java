package org.mesoma.Bookings;

import org.mesoma.Cars.CarService;
import org.mesoma.Cars.Car;
import java.util.List;

public class CarBookingService {
    private final CarBookingDAO carBookingDAO;
    private final CarService carService;

    public CarBookingService(CarBookingDAO carBookingDAO, CarService carService) {
        this.carBookingDAO = carBookingDAO;
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
        return (carBookingDAO.bookings());
    }

    //save booking to database
    public void saveBookingToDAO(CarBooking booking){
        carBookingDAO.saveBooking(booking);
    }

}
