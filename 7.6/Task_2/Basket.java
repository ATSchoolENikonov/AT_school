package Task_2;

import javax.lang.model.type.NullType;
import java.util.*;

public class Basket<T> {
    public HashMap<Plant, NullType> basket = new HashMap<>();


    void addItem(Plant fr) {
        basket.put(fr, null);
    }

    Iterator<Plant> iterator() {
        return basket.keySet().iterator();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket.keySet().iterator().next().getName() +
                '}';
    }
}
