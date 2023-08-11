package org.mesoma.Bookings;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mesoma.Cars.Car;
import org.mesoma.Cars.CarService;
import org.mesoma.User.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarBookingServiceTest {

    @Mock
    private CarBookingDaoInterface carBookingDaoInterface;

    @Mock
    private CarService carService;

    @Mock
    private User mockUser;

    @Mock
    private Car mockCar;

    private CarBookingService carBookingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carBookingService = new CarBookingService(carBookingDaoInterface, carService);
    }

    @Test
    public void testGetAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(mockCar);

        when(carService.getCars()).thenReturn(cars);

        List<Car> result = carBookingService.getAllCars();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(mockCar);
    }

    // Other test methods...

    @Test
    public void testSaveBookingToDAO() {
        CarBooking booking = new CarBooking(UUID.randomUUID(), mockUser, mockCar);

        carBookingService.saveBookingToDAO(booking);

        verify(carBookingDaoInterface, times(1)).saveBooking(booking);
    }

    @Test
    public void testGetAllElectricCars() {
        List<Car> electricCars = new ArrayList<>();
        electricCars.add(mockCar);

        when(carService.getElectricCars()).thenReturn(electricCars);

        List<Car> result = carBookingService.getAllElectricCars();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(mockCar);
    }

    @Test
    public void testGetBookings() {
        List<CarBooking> bookings = new ArrayList<>();
        bookings.add(new CarBooking(UUID.randomUUID(),mockUser, mockCar));
        // Add more bookings as needed

        when(carBookingDaoInterface.getBookings()).thenReturn(bookings);

        List<CarBooking> result = carBookingService.getBookings();

        assertThat(result).hasSize(bookings.size());
        assertThat(result.get(0)).isEqualTo(bookings.get(0));
        // Add more assertions based on the booking details
    }
}
