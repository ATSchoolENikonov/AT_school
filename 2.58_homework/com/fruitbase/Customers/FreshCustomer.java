package com.fruitbase.Customers;

import com.fruitbase.Cargo;
import com.fruitbase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(List<Fruit> purchases, String name) {
        super(purchases, name);
    }

    @Override
    public List<Fruit> takeFruits(Cargo cargo) {
        List<Fruit> k=cargo.getFruit();
        for (int i = 0; i < cargo.getFruit().size(); i++) {
            if (k.get(i).isFresh()) {
                purchases.add(k.get(i));
            }
        }
        return purchases;
    }

    @Override
    public String toString() {
        return "Fresh purchases: " +
                purchases;
    }
}
