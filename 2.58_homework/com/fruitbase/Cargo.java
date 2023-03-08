package com.fruitbase;

import com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cargo {
    private List<Fruit> fruit;

    public Cargo() {
        fruit = new ArrayList<>();
    }

    public double getWeight() {
        double sumWeight = 0;
        for (int i = 0; i < fruit.size(); i++) {
            sumWeight += fruit.get(i).getWeight();
        }
        return sumWeight;
    }

    public BigDecimal getPrice() {
        BigDecimal sumPrice = BigDecimal.valueOf(0);
        for (int i = 0; i < fruit.size(); i++) {
            sumPrice = sumPrice.add(fruit.get(i).getPrice());
        }
        return sumPrice;
    }

    void addFruit(Fruit fr) {
        fruit.add(fr);
    }

    void printList() {
        for (int i = 0; i < fruit.size(); i++) {
            System.out.print(fruit.get(i).getName() + " ");
        }
        System.out.println();
    }
}

