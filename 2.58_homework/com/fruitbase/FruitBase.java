package com.fruitbase;

public class FruitBase {
    private FruitCatalogue catal;

    public FruitBase() {
        catal = new FruitCatalogue();
    }

    public void takeOrder(String[] str) {
        Cargo car = new Cargo();
        for (int i = 0; i < str.length; i++) {
            if (catal.findFruit(str[i]) != null) {
                car.addFruit(catal.findFruit(str[i]));
            }
        }
        car.printList();
        System.out.println("Total Price: " + car.getPrice());
        System.out.println("Total Weight: " + car.getWeight());
    }

    boolean isValid(String[] str) {
        for (int i = 0; i < str.length; i++) {
            if (catal.findFruit(str[i]) != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FruitBase fr = new FruitBase();
        if (args.length != 0 && fr.isValid(args)) {
            fr.takeOrder(args);
        } else {
            System.out.println("No valid order");
            System.exit(12);
        }
    }
}
