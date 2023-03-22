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
        for (int i = 0; i < cargo.getFruit().size(); i++) {
            if (cargo.getFruit().get(i).isFresh()) {
                purchases.add(cargo.getFruit().get(i));
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
