package com.fruitbase;

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

    public static void main(String[] args) {
        FruitBase fr = new FruitBase();
        if (args.length != 0) {
            Cargo car = new Cargo();
            fr.takeOrder(args, car);
            System.out.println(car);
            System.out.println("Total Price: " + car.getPrice());
            System.out.println("Total Weight: " + car.getWeight());
        } else {
            System.out.println("No valid order");
            System.exit(12);
        }
    }
}
