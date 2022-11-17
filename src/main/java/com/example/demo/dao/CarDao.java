// DAO: Data Access Object
// L'interface DAO liste les méthodes qui devront être implémentées pour accéder aux données
// (ex: toutes les données, une donnée en détail, les données filtrée selon une propriété, etc.)

package com.example.demo.dao;
import java.util.List;
import com.example.demo.cars.Car;
// la classe JpaRepository continet toutes les méthodes pour faire un CRUD sur les données: on a juste à réemployer la structure de leur nom
// (ex: findAll, getOne etc)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
// Le contrôleur appellera directement les méthodes du CRUDrepository. J'ajoute dans le DAO uniquement les méthodes dont j'ai besoin en plus:
// En suivant la convention de nommage du JpaRepository, il extrapole la signature de chaque fonction (les nom conventionnels sont proposés en auto-complétion)
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByBrandAndColor(String brand, String color);

}