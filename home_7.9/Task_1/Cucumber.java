package Task_1;

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
