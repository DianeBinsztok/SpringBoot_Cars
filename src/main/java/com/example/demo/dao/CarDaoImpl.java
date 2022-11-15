package com.example.demo.dao;
import com.example.demo.cars.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    //Attribut de l'interface
    public List<Car> cars = new ArrayList<>();

    //Constructeur
    /*Quand le contrôleur appelle l'interface CarDaoImpl, SprintBoot l'instancie. Chaque instance aura l'attribut 'cars' et le constructeur lui transmet ses données*/
    public CarDaoImpl() {
        this.cars.add(new Car(1, "c3", "citroen", "blue"));
        this.cars.add(new Car(2, "advensis", "toyota", "gray"));
        this.cars.add(new Car(3, "punto", "fiat", "red"));
        this.cars.add(new Car(4, "twingo", "renault", "purple"));
        this.cars.add(new Car(5, "c4", "citroen", "gray"));
        this.cars.add(new Car(6, "c4", "citroen", "blue"));
        this.cars.add(new Car(7, "rav4", "toyota", "black"));
        this.cars.add(new Car(8, "punto", "fiat", "blue"));
        this.cars.add(new Car(9, "megane", "renault", "gray"));
        this.cars.add(new Car(10, "picasso", "citroen", "red"));
    }



    //Méthodes
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
