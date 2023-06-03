package Task_2;

public class Tomato implements Vegetable {
    @Override
    public String getName() {
        return "Помидорка";
    }

    @Override
    public String toString() {
        return getName();
    }
}
