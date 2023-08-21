package Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    static <T extends Plant> void makeSalad(Basket<T> baskettt) {
        System.out.println("```" + "\nГотовим салатик: ");
        System.out.print("Режем ");
        for (T item : baskettt) {
            System.out.print(item + " ");
        }
        System.out.println("\nУгощайся!\n" +
                "```");
    }

    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        List<Fruit> multifruit = new ArrayList<>();
        Apples apples = new Apples();
        Banana banana = new Banana();
        Tomato tomato = new Tomato();
        Cucumber cucumber = new Cucumber();
        plants.add(apples);
        plants.add(tomato);
        plants.add(banana);
        plants.add(cucumber);
//        plants.stream().
//                filter((p) -> p instanceof Fruit).
//                forEach(p -> {multifruit.add((Fruit) p);
//                    System.out.println(p);});
        plants.stream().
                filter(p -> p instanceof Fruit).
                map(p -> (Fruit) p).
                collect(Collectors.toCollection(()->multifruit)).
                forEach(System.out::println);
    }
}


