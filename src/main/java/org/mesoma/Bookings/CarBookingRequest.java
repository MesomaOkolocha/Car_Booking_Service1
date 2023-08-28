package org.mesoma.Bookings;

import org.mesoma.Cars.Car;
import org.mesoma.User.User;

import java.util.UUID;

public record CarBookingRequest(User user, Car car) {
}
