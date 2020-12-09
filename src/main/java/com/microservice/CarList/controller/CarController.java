package com.microservice.CarList.controller;

import com.microservice.CarList.model.Car;
import com.microservice.CarList.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/models")
    @ResponseBody
    public List<Car> index(){
        return this.carService.getAllCars();
    }

    @GetMapping("/models/{id}")
    @ResponseBody
    public Car show(@PathVariable final Integer id){
       return this.carService.getCarById(id);
    }

    @PostMapping(path = "/models", consumes = "application/json")
    @ResponseBody
    public void add(@RequestBody Car car){
        this.carService.addCar(car);
    }

    @PutMapping(path = "/models/{id}", consumes = "application/json")
    @ResponseBody
    public void update(@RequestBody Car car, @PathVariable int id){
        this.carService.updateCar(car, id);
    }

    @DeleteMapping( "models/{id}")
    public void deleteCar(@PathVariable int id){
        this.carService.deleteCar(id);
    }


}
