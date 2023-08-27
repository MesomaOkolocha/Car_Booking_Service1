package org.mesoma.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {
    private CarService carService;
    private CarListDataAccessRepository carListDataAccessRepository;

    @BeforeEach
    public void setUp() {
        carListDataAccessRepository = new InMemoryCarListDataAccessRepository(); // Use the in-memory implementation
        carService = new CarService(carListDataAccessRepository);
    }

    @Test
    public void testAddNewCar_Success() {
        Car car = new Car("ABC123", 50.0, Brand.TOYOTA, true);

        carService.addNewCar(car);

        List<Car> cars = carListDataAccessRepository.getCars();
        assertThat(cars).containsExactly(car);
        assertThat(car.isAvailable()).isTrue();
    }

    @Test
    public void testAddNewCar_DuplicateRegNumber() {
        Car existingCar = new Car("ABC123", 50.0, Brand.TOYOTA, true);
        Car newCar = new Car("ABC123", 60.0, Brand.HYUNDAI, false);
        carService.addNewCar(existingCar);
        carService.addNewCar(newCar);
        List<Car> cars = carService.getCars();
        assertThat(cars).containsExactly(existingCar);
        assertThat(existingCar.isAvailable()).isTrue();
    }

    @Test
    public void testGetElectricCars() {
        Car car1 = new Car("ABC123", 50.0, Brand.TESLA, true);
        Car car2 = new Car("ABC124", 60.0, Brand.HYUNDAI, false);
        Car car3 = new Car("ABC125", 60.0, Brand.AUDI, true);
        carService.addNewCar(car1);
        carService.addNewCar(car2);
        carService.addNewCar(car3);
        List<Car> electricCars = carService.getElectricCars();

        assertThat(electricCars).hasSize(2);
        assertThat(electricCars.get(0).getBrand()).isEqualTo(Brand.TESLA);
        assertThat(electricCars.get(1).getBrand()).isEqualTo(Brand.AUDI);
        assertThat(electricCars.get(0).isElectric()).isTrue();
    }

    // In-memory implementation of CarDAO for testing purposes
    private static class InMemoryCarListDataAccessRepository extends CarListDataAccessRepository {
        private final List<Car> cars = new ArrayList<>();

        @Override
        public void registerCar(Car car) {
            cars.add(car);
        }

        @Override
        public List<Car> getCars() {
            return new ArrayList<>(cars);
        }
    }
}
