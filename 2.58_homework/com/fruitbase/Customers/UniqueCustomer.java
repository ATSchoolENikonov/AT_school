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
        int x = 0;
        while (x < cargo.getFruit().size()) {
            for (int i = x + 1; i < cargo.getFruit().size(); i++) {
                if (cargo.getFruit().get(x).getName().equals(cargo.getFruit().get(i).getName())) {
                    cargo.getFruit().remove(i);
                }
            }
            purchases.add(cargo.getFruit().get(x));
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
