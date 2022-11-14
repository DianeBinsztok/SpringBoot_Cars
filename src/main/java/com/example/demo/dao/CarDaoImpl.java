package com.example.demo.dao;

import com.example.demo.cars.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl /*implements CarDao*/{

    public static List<Car> cars = new ArrayList<>();

    static{
        cars.add(new Car(1, "C3", "Citroën", "Blue"));
        cars.add(new Car(2, "Advensis", "Toyota", "Gray"));
        cars.add(new Car(3, "Punto", "Fiat", "Red"));
        cars.add(new Car(4, "Twingo", "Renault", "Purple"));
        cars.add(new Car(5, "Picasso", "Citroën", "Blue"));
    }


    public List<Car> carsIndex() {
        return cars;
    }


    public Car carById(int id) {
        for(Car car: cars){
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }


    public List<Car> carsByBrand(String brand) {
        List<Car> listByBrand = new ArrayList<>();
        for(Car car: cars){
            if(car.getBrand() == brand){
                listByBrand.add(car);
            }
        }
        return listByBrand;
    }
}
