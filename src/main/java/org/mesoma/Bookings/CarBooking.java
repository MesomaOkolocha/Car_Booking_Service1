package org.mesoma.Bookings;

import org.mesoma.Cars.Car;
import org.mesoma.User.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
    private UUID bookingId;
    private User user;
    private Car car;
    private boolean isAvailable;
    private boolean isCancelled;
    private LocalDateTime date;

    public CarBooking(UUID bookingId, User user, Car car) {
        this.bookingId = bookingId;
        this.user = user;
        this.isAvailable = car.isAvailable();
        this.car = car;
        this.date = LocalDateTime.now();
        this.isCancelled = false;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", date=" + date +
                ", isCancelled=" + isCancelled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking booking = (CarBooking) o;
        return isAvailable == booking.isAvailable && isCancelled == booking.isCancelled && Objects.equals(bookingId, booking.bookingId) && Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, isAvailable, isCancelled, date);
    }
}
