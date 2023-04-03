package com.fruitbase.fruits;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Fruit {
    private Freshness freshness;
    private double weight;
    private BigDecimal price;
    private String name;

    public Fruit(Freshness freshness, double weight, BigDecimal price, String name) {
        this.freshness = freshness;
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


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0
                && freshness == fruit.freshness
                && price.equals(fruit.price)
                && name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freshness, weight, price, name);
    }

    public boolean isFresh(){
        return freshness.equals(Freshness.FRESH);
    }
}
