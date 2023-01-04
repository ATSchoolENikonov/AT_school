package ru.pflb.vehicles;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;

public class Car {
    private String model;
    private VehicleClass vehicleClass;
    private double weight;
    private Driver driver;
    Engine engine;

    public Car(String model, VehicleClass vehicleClass, double weight, Driver driver, Engine engine) {
        this.model = model;
        this.vehicleClass = vehicleClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public void start() {
        System.out.println("Going");
    }

    public void stop() {
        System.out.println("Stopping");
    }

    public void turnRight() {
        System.out.println("Turning right");
    }

    public void turnLeft() {
        System.out.println("Turning left");
    }

    @Override
    public String toString() {
        return "Model: " + model + ",class: " + vehicleClass + "\n"
                + "CHARACTERISTICS: " + "\n"
                + "weight: " + weight + "\n"
                + "engine: " + engine + "\n"
                + "driver: " + driver;
    }
}
