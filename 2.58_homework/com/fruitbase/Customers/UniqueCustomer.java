package com.fruitbase.Customers;

import com.fruitbase.Cargo;
import com.fruitbase.fruits.Fruit;

import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(List<Fruit> purchases, String name) {
        super(purchases, name);
    }

    @Override
    public List<Fruit> takeFruits(Cargo cargo) {
        List<Fruit> k=cargo.getFruit();
        int x = 0;
        while (x < cargo.getFruit().size()) {
            for (int i = x + 1; i < k.size(); i++) {
                if (k.get(x).getName().equals(k.get(i).getName())) {
                    k.remove(i);
                }
            }
            purchases.add(k.get(x));
            x++;
        }
        return purchases;
    }

    @Override
    public String toString() {
        return "Unique purchases: " +
                purchases;
    }
}
