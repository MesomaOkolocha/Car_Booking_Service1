package org.mesoma.Bookings;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import org.mesoma.Cars.Car;
import org.mesoma.User.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "car_booking")
public class CarBooking {
    @Id
    @GeneratedValue(generator = "booking_uuid")
    @GenericGenerator(name = "booking_uuid")
    @UuidGenerator
    private UUID bookingId;
    @ManyToOne
    @JoinColumn(name = "user_details", referencedColumnName = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_details", referencedColumnName = "id")
    private Car car;
    @Column(nullable = false)
    private boolean isAvailable;
    @Column(nullable = false)
    private boolean isCancelled;
    @Column(nullable = false)
    private LocalDateTime date;

    public CarBooking(){}

    public CarBooking(User user, Car car) {
        this.user = user;
        this.isAvailable = car.isAvailable();
        this.car = car;
        this.date = LocalDateTime.now();
        this.isCancelled = false;
    }

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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, isAvailable, isCancelled, date);
    }
}
