package org.example;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication <- commented out because it is not used

public class App {

    public static void main(String[] args) {
        SpringApplication.run(ReconTool.class, args);
        System.out.println(String.format("App.main(%s)", Arrays.toString(args)));
        System.out.println("Hello Bitches");
    }
}

