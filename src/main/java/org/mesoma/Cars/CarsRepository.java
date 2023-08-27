package org.mesoma.Cars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends JpaRepository<Car, Integer> {
    boolean existsCarByRegNumber(String regNumber);
    List<Car> findByIsElectricTrue();
    void deleteCarByRegNumber(String regNumber);
    Optional<Car> findCarByRegNumber(String regNumber);
}
