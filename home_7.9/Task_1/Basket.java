package Task_1;

import javax.lang.model.type.NullType;
import java.util.*;

public class Basket<T> implements Iterable<T> {
    public HashMap<T, NullType> basket = new HashMap<>();


    void addItem(T fr) {
        basket.put(fr, null);
    }

    public Iterator<T> iterator() {
        return basket.keySet().iterator();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket.toString() +
                '}';
    }

}
