package org.mesoma.Bookings;

import org.junit.jupiter.api.*;
import org.mesoma.Cars.Brand;
import org.mesoma.Cars.Car;
import org.mesoma.User.User;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.UUID;
public class CarBookingListDataAccessRepositoryTest {

    private CarBookingListDataAccessRepository carBookingListDataAccessRepository;

    @BeforeEach
    public void setUp() {
        carBookingListDataAccessRepository = new CarBookingListDataAccessRepository();
    }

    @Test
    public void testSaveBooking() {
        User user = new User("John");
        Car car = new Car("ABC123", 100.0, Brand.TOYOTA, false);
        CarBooking booking = new CarBooking(UUID.randomUUID(), user, car);

        carBookingListDataAccessRepository.saveBooking(booking);

        List<CarBooking> bookings = carBookingListDataAccessRepository.getBookings();
        assertThat(bookings).containsExactly(booking);
    }

    @Test
    public void testGetBookings() {
        User user = new User("John");
        Car car = new Car("ABC123", 100.0, Brand.TOYOTA, false);
        CarBooking expectedBooking = new CarBooking(UUID.randomUUID(), user, car);
        // Mocking behavior to return expectedBooking
        CarBookingListDataAccessRepository carBookingListDataAccessRepositorySpy = spy(carBookingListDataAccessRepository);
        doReturn(List.of(expectedBooking)).when(carBookingListDataAccessRepositorySpy).getBookings();

        List<CarBooking> actualBookings = carBookingListDataAccessRepositorySpy.getBookings();

        assertThat(actualBookings).containsExactly(expectedBooking);
        verify(carBookingListDataAccessRepositorySpy, times(1)).getBookings();
    }
}
