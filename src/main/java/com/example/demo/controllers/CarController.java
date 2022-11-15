package com.example.demo.controllers;
import com.example.demo.dao.CarDao;
import com.example.demo.cars.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/")
    public List<Car> cars(){
        return this.carDao.carsIndex();
    }
    @GetMapping("/car/{id}")
    public Car carDetail(@PathVariable int id){
        return carDao.carById(id);
    }
    @GetMapping("/brand/{brand}")
    public List<Car> listByBrand(@PathVariable String brand){
        return carDao.carsByBrand(brand);
    }
    @GetMapping("/color/{color}")
    public List<Car> listByColor(@PathVariable String color){
        return carDao.carsByColor(color);
    }
}
