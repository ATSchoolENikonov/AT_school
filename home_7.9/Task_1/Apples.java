package Task_1;

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
