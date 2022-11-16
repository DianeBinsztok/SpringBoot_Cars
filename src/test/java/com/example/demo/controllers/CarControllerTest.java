package com.example.demo.controllers;
import com.example.demo.cars.Car;
import com.example.demo.controllers.CarController;
import com.example.demo.dao.CarDao;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CarControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarController controller;

    @Autowired
    private CarDao dao;

    // Vérifier la présence du dao et du contrôleur
    @Test
    public void contextAndModulesLoad() throws Exception{
        assertThat(controller).isNotNull();
        assertThat(dao).isNotNull();
    }

    // Vérifier que la page d'accueil répond
    @Test
    public void checkIfHomepageResponds() {
        ResponseEntity<List> serverResponse = restTemplate.getForEntity("/", List.class);
        int responseCode = serverResponse.getStatusCodeValue();
        assertThat(responseCode == 200);
    }

    // Vérifier que la page d'accueil renvoie une instance de List
    @Test
    public void checkIfHomepageReturnsAList() {
        ResponseEntity<List> serverResponse = restTemplate.getForEntity("/", List.class);
        assertThat(serverResponse.getBody() instanceof ArrayList);
    }

    // Vérifier que la page car renvoie une instance de car
    @Test
    public void checkIfCarPageReturnsACar() {
        ResponseEntity<Car> serverResponse = restTemplate.getForEntity("/car/1", Car.class);
        assertThat(serverResponse.getBody() instanceof Car);
    }

    // Vérifier que la page car renvoie la bonne instance
    @Test
    public void checkIfCarPageReturnsTheRightCar() {
        ResponseEntity<Car> serverResponse = restTemplate.getForEntity("/car/1", Car.class);
        assertThat((serverResponse.getBody().getId() == 1));
    }
    @Test
    public void checkIfBrandPageReturnsAList() {
    //  ResponseEntity<List> serverResponse = restTemplate.getForEntity("/brand/toyota", List.class);
    //  assertThat(serverResponse.getBody() instanceof ArrayList);

        // ou avec getForObject():
        List<Car> serverResponse = restTemplate.getForObject("/brand/toyota", List.class);
        assertThat(serverResponse instanceof ArrayList);
    }

}