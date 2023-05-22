package Task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants=new ArrayList<>();
        plants.add(new Cucumber());
        plants.add(new Apples());
        plants.add(new Tomato());
        plants.add(new Banana());
        HashMap<String,Plant> map=new HashMap<>();
        for (String key:
             map.keySet()) {
            map.put(plants.get(0).getName())
        }
        System.out.println(map.entrySet());
    }
}
