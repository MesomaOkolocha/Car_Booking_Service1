package org.mesoma.Bookings;

import org.mesoma.Cars.CarService;
import org.mesoma.Cars.Car;
import org.mesoma.User.User;
import org.mesoma.User.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarBookingService {
    private final CarBookingDaoInterface carBookingDaoInterface;
    private final CarService carService;
    private final UserService userService;

    public CarBookingService(@Qualifier("CarBookingJPA") CarBookingDaoInterface carBookingDaoInterface, CarService carService,
    UserService userService) {
        this.carBookingDaoInterface = carBookingDaoInterface;
        this.carService = carService;
        this.userService = userService;
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

    public void bookCar(CarBookingRequest carBookingRequest){
        Car carEntity = carService.getCarByRegNumber(carBookingRequest.car().getRegNumber());
        User userEntity = userService.getUserById(carBookingRequest.user().getUserId());
        CarBooking carBooking = new CarBooking(userEntity, carEntity);
        carBookingDaoInterface.saveBooking(carBooking);
    }

}
