package org.mesoma.Cars;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping()
    public List<Car> getAllCars(){
        return carService.getCars();
    }
    @GetMapping("/ElectricCars")
    public List<Car> getAllElectricCars(){
        return carService.getElectricCars();
    }
    @GetMapping("{regNumber}")
    public Car getCarByRegNumber(@PathVariable("regNumber") String regNumber){
        return carService.getCarByRegNumber(regNumber);
    }
    @DeleteMapping("{regNumber}")
    public void deleteCarByRegNumber(@PathVariable("regNumber") String regNumber){
        carService.deleteCarByRegNumber(regNumber);
    }

    @PostMapping()
    public void insertCar(@RequestBody CarRegistrationRequest carRegistrationRequest){
        carService.registerCar(carRegistrationRequest);
    }
}
