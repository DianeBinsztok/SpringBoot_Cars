package com.example.demo.controllers;
import com.example.demo.dao.CarDao;
import com.example.demo.cars.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.beans.JavaBean;
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


    @PostMapping(value = "/cars")
    // @RequestBody demande à Spring de convertir le corps de la requête HTTP en JSON
    // La requête en JSON sera convertie en objet Car
    public void addCar(@RequestBody Car newCar){
         carDao.save(newCar);
    }

    @PutMapping(value = "/update/{id}")
    public void updateCar(@PathVariable int id, @RequestBody Car newSpecCar){
        carDao.update(id, newSpecCar);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeCar(@PathVariable int id){
        carDao.delete(id);
    }

}
