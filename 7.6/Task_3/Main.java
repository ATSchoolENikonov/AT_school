package Task_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        plants.add(new Cucumber());
        plants.add(new Apples());
        plants.add(new Tomato());
        plants.add(new Banana());
        HashMap<String, Plant> map = new HashMap<>();
        for (Plant grow : plants) {
            map.put(grow.getName(), grow);
        }
        for (Map.Entry<String, Plant> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getClass().getSimpleName());
        }
    }
}
