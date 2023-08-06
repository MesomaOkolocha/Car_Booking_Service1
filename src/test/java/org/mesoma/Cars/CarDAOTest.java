package org.mesoma.Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class CarDAOTest {
    private CarDAO carDAO;

    @BeforeEach
    public void setUp() {
        carDAO = new CarDAO();
    }

    @Test
    public void testSaveCarAndGetCars() {
        Car car1 = new Car("ABC123", 50.0, Brand.TOYOTA, true);
        Car car2 = new Car("XYZ456", 60.0, Brand.TESLA, false);

        carDAO.saveCar(car1);
        carDAO.saveCar(car2);

        List<Car> cars = carDAO.getCars();

        assertThat(cars).containsExactly(car1,car2);
    }
}