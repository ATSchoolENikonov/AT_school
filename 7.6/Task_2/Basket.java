package Task_2;

import javax.lang.model.type.NullType;
import java.util.*;

public class Basket<T> {
    public HashMap<Plant, NullType> basket = new HashMap<>();


    void addItem(Plant fr) {
        basket.put(fr, null);
    }

    Iterator<String> iterator() {
        List<String> names = new ArrayList<>();
        for (Plant key : basket.keySet()) {
            names.add(key.getName());
        }
        Iterator<String> st = names.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next().getName());
//        }
        return st;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket.keySet().iterator().next().getName() +
                '}';
    }
}
