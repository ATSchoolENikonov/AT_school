package com.fruitbase;

import com.fruitbase.Customers.Customer;
import com.fruitbase.Customers.FreshCustomer;
import com.fruitbase.Customers.UniqueCustomer;
import com.fruitbase.fruits.Apple;
import com.fruitbase.fruits.Banana;
import com.fruitbase.fruits.Fruit;
import com.fruitbase.fruits.Pineapple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

