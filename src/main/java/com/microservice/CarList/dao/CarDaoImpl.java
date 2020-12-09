package com.microservice.CarList.dao;

import com.microservice.CarList.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class CarDaoImpl implements CarDao {
    public static ArrayList<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car( 0,"Clio", "red"));
        cars.add(new Car( 1,"C8", "black"));
        cars.add(new Car( 2,"307", "blue"));
    }

    @Override
    public Car getCarById(Integer id) {
       Optional<Car> car = cars.stream()
                .filter(carList -> carList.getId() == id)
                .collect(toList())
                .stream()
                .findFirst();
       return car.orElse(null);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public void updateCar(Car car, int id) {
        for (Car carlist : cars){
            if (carlist.getId() == car.getId()){
                carlist.setBrand(car.getBrand());
                carlist.setColor(car.getColor());
            }
        }
    }

    @Override
    public void deleteCar(Integer id) {
        cars.removeIf(car -> car.getId() == id);
    }
}
