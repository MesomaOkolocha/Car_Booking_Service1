package org.mesoma.Bookings;

import org.junit.jupiter.api.*;
import org.mesoma.Cars.Brand;
import org.mesoma.Cars.Car;
import org.mesoma.User.User;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.UUID;
public class CarBookingDAOTest {

    private CarBookingDAO carBookingDAO;

    @BeforeEach
    public void setUp() {
        carBookingDAO = new CarBookingDAO();
    }

    @Test
    public void testSaveBooking() {
        User user = new User("John");
        Car car = new Car("ABC123", 100.0, Brand.TOYOTA, false);
        CarBooking booking = new CarBooking(UUID.randomUUID(), user, car);

        carBookingDAO.saveBooking(booking);

        List<CarBooking> bookings = carBookingDAO.getBookings();
        assertThat(bookings).containsExactly(booking);
    }

    @Test
    public void testGetBookings() {
        User user = new User("John");
        Car car = new Car("ABC123", 100.0, Brand.TOYOTA, false);
        CarBooking expectedBooking = new CarBooking(UUID.randomUUID(), user, car);
        // Mocking behavior to return expectedBooking
        CarBookingDAO carBookingDAOSpy = spy(carBookingDAO);
        doReturn(List.of(expectedBooking)).when(carBookingDAOSpy).getBookings();

        List<CarBooking> actualBookings = carBookingDAOSpy.getBookings();

        assertThat(actualBookings).containsExactly(expectedBooking);
        verify(carBookingDAOSpy, times(1)).getBookings();
    }
}
