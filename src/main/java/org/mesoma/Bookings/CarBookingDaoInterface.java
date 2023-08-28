package org.mesoma.Bookings;

import java.util.List;

public interface CarBookingDaoInterface {
    void saveBooking(CarBooking booking);

    List<CarBooking> getBookings();

}
