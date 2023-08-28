package org.mesoma.Bookings;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("CarBookingJPA")
public class CarBookingJPADataAccessRepository implements CarBookingDaoInterface{
    private final CarBookingRepository carBookingRepository;

    public CarBookingJPADataAccessRepository(CarBookingRepository carBookingRepository) {
        this.carBookingRepository = carBookingRepository;
    }

    @Override
    public void saveBooking(CarBooking booking) {
        carBookingRepository.save(booking);
    }

    @Override
    public List<CarBooking> getBookings() {
        return carBookingRepository.findAll();
    }
}
