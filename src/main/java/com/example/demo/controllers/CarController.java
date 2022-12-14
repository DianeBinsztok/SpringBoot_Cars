package com.example.demo.controllers;
import com.example.demo.dao.CarDao;
import com.example.demo.cars.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.Thymeleaf;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

// Rest Controller envoie du JSON
// si je veux envoyer un template, j'utilise l'annotation @Controller
@RestController
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/")
    public List<Car> cars(){
        return this.carDao.findAll();
    }
    @GetMapping("/car/{id}")
    public Car carDetail(@PathVariable int id){
        return carDao.findById(id).get();
    }

    // on pouvait aussi écrire:
    // public Optional<Car> carDetail(@PathVariable int id){
    //        return carDao.findById(id);
    //    }
    @GetMapping("/brand/{brand}")
    public List<Car> listByBrand(@PathVariable String brand){
        return carDao.findByBrand(brand);
    }
    @GetMapping("/color/{color}")
    public List<Car> listByColor(@PathVariable String color){
        return carDao.findByColor(color);
    }

// Marche pas => ne renvoie pas d'erreur mais ne trouve pas les données
//    @GetMapping("/color-brand/{color}-{brand}")
//    public String listByBrandAndColor(@PathVariable String color, @PathVariable String brand, Model model){
//        List<Car> cars = carDao.findByBrandAndColor(color, brand);
//        System.out.println(cars);
//        model.addAttribute("cars", cars);
//        model.addAttribute("title", "All our available "+color+" "+brand);
//        return "index";
//    }

    @PostMapping(value = "/cars")
    // @RequestBody demande à Spring de convertir le corps de la requête HTTP en JSON
    // La requête en JSON sera convertie en objet Car
    public void addCar(@RequestBody Car newCar){
        carDao.save(newCar);
    }

    @PutMapping(value = "/update/{id}")
    public void updateCar(@PathVariable int id, @RequestBody Car newSpecCar){
       carDao.save(newSpecCar);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeCar(@PathVariable int id){
        // La méthode findById a pour retour un Optional<Objet> :
        // l'instance Optional<Car> signifie que le résultat peut être une instance de Car ou rien (si l'id n'existe pas)
        Optional<Car> target = carDao.findById(id);
        target.ifPresent(carDao::delete);
    }

}
