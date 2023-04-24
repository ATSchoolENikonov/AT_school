package com.fruitbase.Customers;


import com.fruitbase.Delivery;
import com.fruitbase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(List<Fruit> purchases, String name) {
        super(purchases, name);
    }

    @Override
    public List<Fruit> takeFruits(Delivery cargo) {
        List<Fruit> k = cargo.getFruits();
        for (int i = 0; i < cargo.getFruits().size(); i++) {
            if (k.get(i).isFresh()) {
                purchases.add(k.get(i));
            }
        }
        for (int i = 0; i < purchases.size(); i++) {
            cargo.removeFruit(purchases.get(i));
        }
        return purchases;
    }

    @Override
    public String toString() {
        return "Fresh purchases: " +
                purchases;
    }
}
