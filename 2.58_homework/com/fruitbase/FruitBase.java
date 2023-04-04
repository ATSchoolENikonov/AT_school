package com.fruitbase;

import java.io.*;

public class FruitBase implements Serializable{
    private static final long serialVersionUID=2L;
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

    public void exportCatalogue() {
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Fruitbase\\HomeWork\\home.ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(catal);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Каталог эскпортирован");
    }

    public void importCatalogue() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream("C:\\Fruitbase\\HomeWork\\home.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            this.catal = (FruitCatalogue) objectInputStream.readObject();
        System.out.println("Каталог импортирован");
    }
}
