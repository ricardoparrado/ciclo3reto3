package com.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.usa.ciclo3.ciclo3.model"})
// Le dice a la aplicacion en donde estan las clases que representan tablas en la BD
@SpringBootApplication
public class Ciclo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Ciclo3Application.class, args);
    }

}
