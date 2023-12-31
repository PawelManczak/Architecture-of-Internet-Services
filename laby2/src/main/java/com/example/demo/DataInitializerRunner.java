package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerRunner implements CommandLineRunner {

    private final DataInitializer dataInitializer;

    public DataInitializerRunner(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    @Override
    public void run(String... args) {
        dataInitializer.initializeSampleData();
    }
}
