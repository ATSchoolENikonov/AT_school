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
        List<Fruit> k=cargo.getFruits();
        int x = 0;
        while (x < cargo.getFruits().size()) {
            for (int i = x + 1; i < k.size(); i++) {
                if (k.get(x).equals(k.get(i))) {
                    cargo.removeFruit(k.get(i));
//                    k.remove(i);
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
