package ru.pflb.details;

public class Engine {
    private double power;
    private String vendor;

    public Engine(double power, String vendor) {
        this.power = power;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return vendor + " - " + power;
    }
}
