package org.mesoma.Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("ABC123", 50.0, Brand.TOYOTA, true);
    }

    @Test
    public void testCarInitialization() {
        assertNotNull(car);
        assertEquals("ABC123", car.getRegNumber());
        assertEquals(50.0, car.getRentalPrice(), 0.01);
        assertEquals(Brand.TOYOTA, car.getBrand());
        assertTrue(car.isElectric());
        assertFalse(car.isAvailable());
    }

    @Test
    void getRegNumber() {
        assertEquals("ABC123", car.getRegNumber());
    }

    @Test
    void setRegNumber() {
        car.setRegNumber("XYZ456");
        assertEquals("XYZ456", car.getRegNumber());
    }

    @Test
    void getRentalPrice() {
        assertEquals(50.0, car.getRentalPrice(), 0.01);
    }

    @Test
    void setRentalPrice() {
        car.setRentalPrice(60.0);
        assertEquals(60.0, car.getRentalPrice(), 0.01);
    }

    @Test
    void getBrand() {
        assertEquals(Brand.TOYOTA, car.getBrand());
    }

    @Test
    void setBrand() {
        car.setBrand(Brand.TESLA);
        assertEquals(Brand.TESLA, car.getBrand());
    }

    @Test
    void isElectric() {
        assertTrue(car.isElectric());
    }

    @Test
    void setElectric() {
        car.setElectric(false);
        assertFalse(car.isElectric());
    }

    @Test
    void isAvailable() {
        assertFalse(car.isAvailable());
    }

    @Test
    void setAvailable() {
        car.setAvailable(true);
        assertTrue(car.isAvailable());
    }

    @Test
    public void testToString() {
        String expectedToString = "Car{" +
                "regNumber='ABC123', " +
                "rentalPrice=50.0, " +
                "brand=TOYOTA, " +
                "isElectric=true" +
                "}";

        String actualToString = car.toString();

        assertThat(actualToString).isEqualTo(expectedToString);
    }
    @Test
    void testCarEqualsAndHashCode() {
        Car sameCar = new Car("ABC123", 50.0, Brand.TOYOTA, true);
        assertThat(car).isEqualTo(sameCar);
        assertThat(car.hashCode()).isEqualTo(sameCar.hashCode());
    }

}