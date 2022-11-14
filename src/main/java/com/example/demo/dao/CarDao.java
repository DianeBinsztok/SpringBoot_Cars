// DAO: Data Access Object
// L'interface dao liste les méthodes qui devront être implémentées pour accéder aux données
// (ex: toutes les données, une donnée en détail, les données filtrée selon une propriété, etc.)

package com.example.demo.dao;
import java.util.List;
import com.example.demo.cars.Car;

public interface CarDao {
    List<Car> carsIndex();

    Car carById(int id);

    List<Car> carsByBrand(String brand);
}
