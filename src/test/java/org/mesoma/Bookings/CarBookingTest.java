package org.mesoma.Bookings;

import org.junit.jupiter.api.Test;
import org.mesoma.Cars.Brand;
import org.mesoma.Cars.Car;
import org.mesoma.User.User;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarBookingTest {

    @Test
    public void testCarBookingCreation() {
        // Arrange
        UUID bookingId = UUID.randomUUID();
        User user = mock(User.class);
        Car car = mock(Car.class);
        when(car.isAvailable()).thenReturn(true);

        // Act
        CarBooking booking = new CarBooking(bookingId, user, car);

        // Assert
        assertThat(booking.getBookingId()).isEqualTo(bookingId);
        assertThat(booking.getUser()).isEqualTo(user);
        assertThat(booking.getCar()).isEqualTo(car);
        assertThat(booking.isAvailable()).isEqualTo(true); // car.isAvailable() is mocked to return true
        assertThat(booking.isCancelled()).isFalse();
        assertThat(booking.getDate()).isNotNull();
    }

    @Test
    public void testCarBookingEquality() {
        // Arrange
        UUID bookingId = UUID.randomUUID();
        User user = mock(User.class);
        Car car = mock(Car.class);
        when(car.isAvailable()).thenReturn(true);

        // Mock LocalDateTime.now() to return a specific value
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 8, 8, 15, 13, 58, 341_769_000);
        try (MockedStatic<LocalDateTime> mockedStatic = mockStatic(LocalDateTime.class)) {
            mockedStatic.when(LocalDateTime::now).thenReturn(specificDateTime);

            CarBooking booking1 = new CarBooking(bookingId, user, car);
            CarBooking booking2 = new CarBooking(bookingId, user, car);

            // Act & Assert
            assertThat(booking1).isEqualTo(booking2);
        }
    }

    @Test
    public void testCarBookingCancellation() {
        // Arrange
        UUID bookingId = UUID.randomUUID();
        User user = mock(User.class);
        Car car = mock(Car.class);
        when(car.isAvailable()).thenReturn(true);

        CarBooking booking = new CarBooking(bookingId, user, car);

        // Act
        booking.setCancelled(true);

        // Assert
        assertThat(booking.isCancelled()).isTrue();
    }

    @Test
    public void testHashCode() {
        UUID bookingId = UUID.randomUUID();
        User user = new User("John");
        Car car = new Car("123",30.0, Brand.TOYOTA,true);
        LocalDateTime date = LocalDateTime.of(2023, 8, 11, 12, 0);

        CarBooking booking1 = new CarBooking(bookingId, user, car);
        booking1.setDate(date);

        CarBooking booking2 = new CarBooking(bookingId, user, car);
        booking2.setDate(date);

        assertThat(booking1.hashCode()).isEqualTo(booking2.hashCode());
    }

    @Test
    public void testToString() {
        UUID bookingId = UUID.randomUUID();
        User user = new User("John");
        Car car = new Car("123",30.0, Brand.TOYOTA,true);
        LocalDateTime date = LocalDateTime.of(2023, 8, 11, 12, 0);

        CarBooking booking = new CarBooking(bookingId, user, car);
        booking.setDate(date);

        String expectedToString = "CarBooking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", date=" + date +
                ", isCancelled=false" +
                '}';
        assertThat(booking.toString()).isEqualTo(expectedToString);
    }

    @Test
    public void testSetUser() {
        UUID bookingId = UUID.randomUUID();
        User user1 = new User("John");
        User user2 = new User("King");
        Car car = new Car("123",30.0, Brand.TOYOTA,true);

        CarBooking booking = new CarBooking(bookingId, user1, car);
        booking.setUser(user2);

        assertThat(booking.getUser()).isEqualTo(user2);
    }
}
