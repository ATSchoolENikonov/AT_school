package com.fruitbase.fruits;

import java.math.BigDecimal;

public abstract class Fruit {
    private double weight;
    private BigDecimal price;
    private String name;

    public Fruit(double weight, BigDecimal price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
