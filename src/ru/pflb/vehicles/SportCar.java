package ru.pflb.vehicles;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;

public class SportCar extends Car {
    private int maxVelocity;

    public SportCar(String model, VehicleClass vehicleClass, double weight, Driver driver, Engine engine, int maxVelocity) {
        super(model, vehicleClass, weight, driver, engine);
        this.maxVelocity = maxVelocity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Max velocity: " + maxVelocity;
    }
}
