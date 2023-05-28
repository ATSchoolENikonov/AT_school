package Task_2;

public class Banana implements Fruit {
    @Override
    public String getName() {
        return "Банан";
    }
    @Override
    public String toString() {
        return getName();
    }
}
