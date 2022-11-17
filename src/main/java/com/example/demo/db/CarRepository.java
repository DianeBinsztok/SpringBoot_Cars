package com.example.demo.db;
// Spring va auto-implémenter un Bean appelé carRepository
import org.springframework.data.repository.CrudRepository;
import com.example.demo.cars.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
