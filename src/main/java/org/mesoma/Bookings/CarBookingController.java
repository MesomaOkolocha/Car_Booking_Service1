package org.mesoma.Bookings;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
public class CarBookingController {
    private final CarBookingService carBookingService;

    public CarBookingController(CarBookingService carBookingService) {
        this.carBookingService = carBookingService;
    }
    @GetMapping()
    public List<CarBooking> getBookings(){
        return carBookingService.getBookings();
    }
    @PostMapping()
    public void bookCar(@RequestBody CarBookingRequest carBookingRequest){
        carBookingService.bookCar(carBookingRequest);
    }
}
