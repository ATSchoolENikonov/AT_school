package com.fruitbase.Customers;

import com.fruitbase.Delivery;
import com.fruitbase.fruits.Fruit;

import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(List<Fruit> purchases, String name) {
        super(purchases, name);
    }

    @Override
    public List<Fruit> takeFruits(Delivery cargo) {
        List<Fruit> k = cargo.getFruits();
        for (int i = 0; i < k.size(); i++) {
            Fruit fr = k.get(i);
            if (!purchases.contains(fr)) {
                purchases.add(fr);
            }
        }
        for (int i = 0; i < purchases.size(); i++) {
            cargo.removeFruit(purchases.get(i));
        }
        return purchases;
    }

    @Override
    public String toString() {
        return "Unique purchases: " +
                purchases;
    }
}
