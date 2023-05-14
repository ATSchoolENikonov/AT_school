package com.fruitbase;

import java.io.*;

public class FruitBase implements Serializable {
    private static final long serialVersionUID = 2L;
    private FruitCatalogue catal;
    private static String ThisIsTheWay = "2.58_homework/com/fruitbase/fruits/TestTask";

    public FruitBase() {
        catal = new FruitCatalogue();
    }

    public static String getThisIsTheWay() {
        return ThisIsTheWay;
    }

    public void takeOrder(String[] str, Delivery car) {
        for (int i = 0; i < str.length; i++) {
            if (catal.findFruit(str[i]) != null) {
                car.addFruit(catal.findFruit(str[i]));
            }
        }
    }

    public void exportCatalogue(String st) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(st);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(catal);
        objectOutputStream.close();
    }

    public void importCatalogue(String st) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(st);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        this.catal = (FruitCatalogue) objectInputStream.readObject();
        objectInputStream.close();
    }
}
