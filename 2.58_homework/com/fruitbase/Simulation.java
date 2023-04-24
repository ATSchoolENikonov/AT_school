package com.fruitbase;

import com.fruitbase.Customers.Customer;
import com.fruitbase.Customers.FreshCustomer;
import com.fruitbase.Customers.UniqueCustomer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulation {
    public static void main(String[] args) {
        FruitBase fr = new FruitBase();
        if (args.length == 0) {
            System.out.println("No valid order");
            System.exit(12);
        }
        if (args[0].contains("-e") || args[0].contains("--export")) {
            String s;
            if (args[0].contains("=") && args[0].substring(3).length() != 0) {
                s = args[0].substring(3);
            } else {
                System.out.println("Каталог будет экспортирован по дефолтному пути");
                s = FruitBase.getThisIsTheWay();
            }
            try {
                fr.exportCatalogue(s);
            } catch (FileNotFoundException e) {
                System.out.println("Не найден файл " + s);
                System.exit(11);
            } catch (IOException e) {
                System.out.println("Ошибка при экспорте каталога в " + s);
                System.exit(12);
            } catch (RuntimeException | Error error) {
                System.out.println("Непредведенная ошибка при экспорте каталога из файла " + s);
                System.exit(13);
            }
            System.out.println("Каталог эскпортирован");
        }
        if (args[0].contains("-i") || args[0].contains("--import")) {
            String s;
            if (args[0].contains("=") && args[0].substring(3).length() != 0) {
                s = args[0].substring(3);
            } else {
                System.out.println("Каталог будет импортирован из дефолтного пути");
                s = FruitBase.getThisIsTheWay();
            }
            try {
                fr.importCatalogue(s);
            } catch (FileNotFoundException e) {
                System.out.println("Не найден файл " + s);
                System.exit(11);
            } catch (IOException e) {
                System.out.println("Ошибка при импорта каталога из " + s);
                System.exit(12);
            } catch (UnsupportedClassVersionError e) {
                System.out.println("Невозможно импортировать каталог из файла : неподдерживаемая версия");
                System.exit(14);
            } catch (RuntimeException | Error | ClassNotFoundException error) {
                System.out.println("Непредведенная ошибка при импорте каталога из файла " + s);
                System.exit(13);
            }
            System.out.println("Каталог импортирован");
        }
        Customer[] customers = new Customer[]{
                new FreshCustomer(new ArrayList<>(), "Ivan"),
                new UniqueCustomer(new ArrayList<>(), "Lexa")
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
