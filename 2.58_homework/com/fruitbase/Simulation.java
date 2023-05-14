package com.fruitbase;

import com.fruitbase.Customers.Customer;
import com.fruitbase.Customers.FreshCustomer;
import com.fruitbase.Customers.UniqueCustomer;
import com.fruitbase.fruits.Fruit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
    String extractPath(String argument) {
        String s;
        if (argument.contains("=") && argument.substring(3).length() != 0) {
            s = argument.substring(3);
        } else {
            s = FruitBase.getThisIsTheWay();
            System.out.println("Не указан путь до файла... " + "\nЗапись/чтение по дефолтному пути...");
        }
        return s;
    }

    void tryExport(FruitBase base, String path) {
        try {
            base.exportCatalogue(path);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + path);
            System.exit(11);
        } catch (IOException e) {
            System.out.println("Ошибка при экспорте каталога в " + path);
            System.exit(12);
        } catch (RuntimeException | Error error) {
            System.out.println("Непредведенная ошибка при экспорте каталога из файла " + path);
            System.exit(13);
        }
    }

    void tryImport(FruitBase base, String path) {
        try {
            base.importCatalogue(path);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл " + path);
            System.exit(11);
        } catch (InvalidClassException e) {
            System.out.println("Невозможно импортировать каталог из файла : неподдерживаемая версия");
            System.exit(14);
        } catch (IOException e) {
            System.out.println("Ошибка при импорта каталога из " + path);
            System.exit(12);
        } catch (RuntimeException | Error | ClassNotFoundException error) {
            System.out.println("Непредведенная ошибка при импорте каталога из файла " + path);
            System.exit(13);
        }
    }

    public static void main(String[] args) {
        FruitBase fr = new FruitBase();
        Simulation sim = new Simulation();
        if (args.length == 0) {
            System.out.println("No valid order");
            System.exit(12);
        }
        if (args[0].contains("-e") || args[0].contains("--export")) {
            sim.tryExport(fr, sim.extractPath(args[0]));
            System.out.println("Каталог эскпортирован");
        }
        if (args[0].contains("-i") || args[0].contains("--import")) {
            sim.tryImport(fr, sim.extractPath(args[0]));
            System.out.println("Каталог импортирован");
        }
        Customer[] customers = new Customer[]{
                new FreshCustomer(new ArrayList<>(), "Ivan"),
                new UniqueCustomer(new ArrayList<>(), "Lexa"),
                new Customer(new ArrayList<>(), "AnonymousAnton") {
                    @Override
                    public List<Fruit> takeFruits(Delivery cargo) {
                        List<Fruit> k = cargo.getFruits();
                        double max = cargo.getMaxPrice().doubleValue();
                        for (int i = 0; i < cargo.getFruits().size(); i++) {
                            if ((k.get(i).getPrice().doubleValue() / max) > 0.75) {
                                purchases.add(k.get(i));
                            }
                        }
                        for (int i = 0; i < purchases.size(); i++) {
                            cargo.removeFruit(purchases.get(i));
                        }
                        return purchases;
                    }

                    @Override
                    public String toString() {
                        return "Expensive purchases: " +
                                purchases;
                    }
                }
        };
        Delivery car = new Cargo();
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
