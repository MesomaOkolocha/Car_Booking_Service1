package org.mesoma.Bookings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarBookingRepository extends JpaRepository<CarBooking, UUID> {
}
