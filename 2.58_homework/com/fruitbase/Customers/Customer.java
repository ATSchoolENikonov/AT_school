package com.fruitbase.Customers;

import com.fruitbase.Cargo;
import com.fruitbase.Delivery;
import com.fruitbase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    protected List<Fruit> purchases;
    protected String name;

    public Customer(List<Fruit> purchases,String name) {
        this.purchases = new ArrayList<>();
        this.name = name;
    }

    public abstract List<Fruit> takeFruits(Delivery customerChoice);
}
