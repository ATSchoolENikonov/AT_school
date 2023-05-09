package com.fruitbase;

import com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cargo implements Delivery {
    private List<Fruit> fruit;

    public Cargo() {
        fruit = new ArrayList<>();
    }

    public List<Fruit> getFruits() {
        return fruit;
    }

    public double getWeight() {
        double sumWeight = 0;
        for (int i = 0; i < fruit.size(); i++) {
            sumWeight += fruit.get(i).getWeight();
        }
        return sumWeight;
    }

    public BigDecimal getPrice() {
        BigDecimal sumPrice = BigDecimal.ZERO;
        for (int i = 0; i < fruit.size(); i++) {
            sumPrice = sumPrice.add(fruit.get(i).getPrice());
        }
        return sumPrice;
    }

    public void addFruit(Fruit fr) {
        fruit.add(fr);
    }

    public void removeFruit(Fruit fr) {
        for (int i = 0; i < fruit.size(); i++) {
            if (fr.equals(fruit.get(i))) {
                fruit.remove(i);
                return;
            }
        }
    }

    @Override
    public BigDecimal getMaxPrice() {
        BigDecimal max = BigDecimal.ZERO;
        for (int i = 0; i < fruit.size(); i++) {
            if (fruit.get(i).getPrice().compareTo(max) > 0) {
                max = fruit.get(i).getPrice();
            }
        }
        return max;
    }


    @Override
    public String toString() {
        return "Cargo: " +
                fruit;
    }
}

