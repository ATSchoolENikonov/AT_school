package Task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        plants.add(new Cucumber());
        plants.add(new Apples());
        plants.add(new Tomato());
        plants.add(new Banana());
        HashMap<String, Plant> map = new HashMap<>();
        for (Plant grow :
                plants) {
            map.put(grow.getName(), grow);
        }
        Iterator<Plant> it=map.values().iterator();
        Iterator<String> names=map.keySet().iterator();
        while (it.hasNext()){
            System.out.println(names.next()+ " " +  it.next().getClass().getSimpleName());
        }
    }
}
