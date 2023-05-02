package com.fruitbase;

import com.fruitbase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class FruitCatalogue implements Serializable {
    private static final long serialVersionUID=3L;
    private Fruit[] fruitCatal;

    public FruitCatalogue() {
        fruitCatal = new Fruit[]{
                new Pineapple(Freshness.FRESH, 44, BigDecimal.valueOf(12), "Pineapple"),
                new Apple(Freshness.SPOILED, 12, BigDecimal.valueOf(1), "Apple"),
                new Banana(Freshness.FRESH, 311, BigDecimal.valueOf(33), "Banana"),
                new Orange(Freshness.FRESH, 55, BigDecimal.valueOf(2), "Orange"),
                new Fruit(Freshness.FRESH, 14, BigDecimal.valueOf(22), "Kiwi") {},
                new Fruit(Freshness.SPOILED, 99, BigDecimal.valueOf(777), "Mango") {} };
    }

    Fruit findFruit(String str) {
        for (int i = 0; i < fruitCatal.length; i++) {
            if (str.equals(fruitCatal[i].getName())) {
                return fruitCatal[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FruitCatalogue{" +
                "fruitCatal=" + Arrays.toString(fruitCatal) +
                '}';
    }
}
