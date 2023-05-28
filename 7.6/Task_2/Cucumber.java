package Task_2;

public class Cucumber implements Vegetable {
    @Override
    public String getName() {
        return "Огурец";
    }
    @Override
    public String toString() {
        return getName();
    }
}
