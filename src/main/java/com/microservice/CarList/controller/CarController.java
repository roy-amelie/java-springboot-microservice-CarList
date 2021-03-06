package com.microservice.CarList.controller;

import com.microservice.CarList.model.Car;
import com.microservice.CarList.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/models")
    public List<Car> index(){
        return this.carService.getAllCars();
    }

    @GetMapping("/models/{id}")
    public Optional<Car> show(@PathVariable final Integer id){
       return this.carService.getCarById(id);
    }

    @PostMapping(path = "/models", consumes = "application/json")
    public void add(@RequestBody Car car){
        this.carService.addCar(car);
    }

    @PutMapping(path = "/models/{id}", consumes = "application/json")
    public void update(@RequestBody Car car, @PathVariable int id){
        this.carService.updateCar(car, id);
    }

    @DeleteMapping( "models/{id}")
    public void deleteCar(@PathVariable int id){
        this.carService.deleteCar(id);
    }

}
