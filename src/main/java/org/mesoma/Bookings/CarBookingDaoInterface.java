package org.mesoma.Bookings;

import java.util.List;

public interface CarBookingDaoInterface {
    public void saveBooking(CarBooking booking);

    public List<CarBooking> getBookings();
}
