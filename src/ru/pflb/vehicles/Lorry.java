package ru.pflb.vehicles;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;

public class Lorry extends Car{
    private double loadingAmount;

    public Lorry(String model, VehicleClass vehicleClass, double weight, Driver driver, Engine engine,double loadingAmount) {
        super(model, vehicleClass, weight, driver, engine);
        this.loadingAmount=loadingAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Loading amount: "+loadingAmount;
    }
}
