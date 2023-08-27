package org.mesoma.Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class CarListDataAccessRepositoryTest {
    private CarListDataAccessRepository carListDataAccessRepository;

    @BeforeEach
    public void setUp() {
        carListDataAccessRepository = new CarListDataAccessRepository();
    }

    @Test
    public void testSaveCarAndGetCars() {
        Car car1 = new Car("ABC123", 50.0, Brand.TOYOTA, true);
        Car car2 = new Car("XYZ456", 60.0, Brand.TESLA, false);

        carListDataAccessRepository.registerCar(car1);
        carListDataAccessRepository.registerCar(car2);

        List<Car> cars = carListDataAccessRepository.getCars();

        assertThat(cars).containsExactly(car1,car2);
    }
}