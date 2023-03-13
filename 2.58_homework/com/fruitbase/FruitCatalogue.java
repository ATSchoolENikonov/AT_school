package com.fruitbase;

import com.fruitbase.fruits.*;

import java.math.BigDecimal;
import java.util.Arrays;

public class FruitCatalogue {
    private Fruit[] fruitCatal;

    public FruitCatalogue() {
        fruitCatal = new Fruit[]{
                new Pineapple(12, BigDecimal.valueOf(33), "Pineapple"),
                new Apple(7, BigDecimal.valueOf(13), "Apple"),
                new Banana(34, BigDecimal.valueOf(66), "Banana"),
                new Orange(77, BigDecimal.valueOf(3), "Orange")};
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
