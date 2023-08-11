package org.mesoma.Bookings;

import java.util.ArrayList;
import java.util.List;

public class CarBookingDAO implements CarBookingDaoInterface{
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
