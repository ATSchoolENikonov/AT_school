package Task_2;

public class Apples implements Fruit {
    @Override
    public String getName() {
        return "Яблоко";
    }

    @Override
    public String toString() {
        return getName();
    }
}
