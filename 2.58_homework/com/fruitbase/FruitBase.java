package com.fruitbase;

public class FruitBase {
    private FruitCatalogue catal;

    public FruitBase() {
        catal = new FruitCatalogue();
    }

    public void takeOrder(String[] str, Cargo car) {
        for (int i = 0; i < str.length; i++) {
            if (catal.findFruit(str[i]) != null) {
                car.addFruit(catal.findFruit(str[i]));
            }
        }
    }
}

