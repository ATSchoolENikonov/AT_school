package com.fruitbase;

import java.io.*;

public class FruitBase implements Serializable{
    private static final long serialVersionUID=2L;
    private FruitCatalogue catal;

    public FruitBase() {
        catal = new FruitCatalogue();
    }

    public void takeOrder(String[] str, Delivery car) {
        for (int i = 0; i < str.length; i++) {
            if (catal.findFruit(str[i]) != null) {
                car.addFruit(catal.findFruit(str[i]));
            }
        }
    }

    public void exportCatalogue() {
        try (FileOutputStream outputStream = new FileOutputStream("home.ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(catal);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Каталог эскпортирован");
    }

    public void importCatalogue() {
        try (FileInputStream inputStream = new FileInputStream("home.ser")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            this.catal = (FruitCatalogue) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Каталог импортирован");
    }
}
