package com.example.demo.dao;
import com.example.demo.cars.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    public static List<Car> cars = new ArrayList<>();

    static{
        cars.add(new Car(1, "c3", "citroen", "blue"));
        cars.add(new Car(2, "advensis", "toyota", "gray"));
        cars.add(new Car(3, "punto", "fiat", "red"));
        cars.add(new Car(4, "twingo", "renault", "purple"));
        cars.add(new Car(5, "c4", "citroen", "gray"));
        cars.add(new Car(6, "c4", "citroen", "blue"));
        cars.add(new Car(7, "rav4", "toyota", "black"));
        cars.add(new Car(8, "punto", "fiat", "blue"));
        cars.add(new Car(9, "megane", "renault", "gray"));
        cars.add(new Car(10, "picasso", "citroen", "red"));
    }

    @Override
    public List<Car> carsIndex() {
        return cars;
    }

    @Override
    public Car carById(int id) {
        for(Car car: cars){
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> carsByBrand(String brand) {
        List<Car> listByBrand = new ArrayList<>();
        for(Car car: cars){
            if(car.getBrand().equals(brand)){
                listByBrand.add(car);
            }

        }
        return listByBrand;
    }

    @Override
    public List<Car> carsByColor(String color) {
        List<Car> listByColor = new ArrayList<>();
        for(Car car: cars){
            if(car.getColor().equals(color)){
                listByColor.add(car);
            }

        }
        return listByColor;
    }

    @Override
    public void save(Car newCar) {
        cars.add(newCar);
    }

    @Override
    public void update(int id, Car newSpecCar) {
        Car target = carById(id);
        cars.set(cars.indexOf(target), newSpecCar);
    }

    @Override
    public void delete(int id) {
        cars.remove(carById(id));
    }
}
