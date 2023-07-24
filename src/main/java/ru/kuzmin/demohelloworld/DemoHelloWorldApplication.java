package ru.kuzmin.demohelloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHelloWorldApplication {



    public static void main(String[] args) {
        SpringApplication.run(DemoHelloWorldApplication.class, args);
    }

}
