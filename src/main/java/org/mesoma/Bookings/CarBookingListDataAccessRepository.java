package org.mesoma.Bookings;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CarBookingList")
public class CarBookingListDataAccessRepository implements CarBookingDaoInterface{
    private static final List<CarBooking> bookings;

    static{
        bookings = new ArrayList<>();
    }

    public void saveBooking(CarBooking booking){
        bookings.add(booking);
    }

    public List<CarBooking> getBookings(){
        return bookings;
    }
}
