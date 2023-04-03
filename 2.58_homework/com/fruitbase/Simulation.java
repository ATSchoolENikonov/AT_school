package com.fruitbase;

import com.fruitbase.Customers.Customer;
import com.fruitbase.Customers.FreshCustomer;
import com.fruitbase.Customers.UniqueCustomer;

import java.util.ArrayList;
import java.util.Arrays;

public class Simulation {
    public static void main(String[] args) {
        FruitBase fr = new FruitBase();
        Customer[] customers = new Customer[]{
                new FreshCustomer(new ArrayList<>(), "Ivan"),
                new UniqueCustomer(new ArrayList<>(), "Lexa")
        };
        if (args.length == 0) {
            System.out.println("No valid order");
            System.exit(12);
        }
        Cargo car = new Cargo();
        fr.takeOrder(args, car);
        System.out.println(car);
        System.out.println("Total Price: " + car.getPrice());
        System.out.println("Total Weight: " + car.getWeight());
        for (int i = 0; i < customers.length; i++) {
            customers[i].takeFruits(car);
        }
        System.out.println(Arrays.toString(customers));

    }
}
