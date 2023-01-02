package Animals;

public class Horse extends Animal {
    public Horse(String name, String food, int foodCounter, String location, int counter, HealthState health) {
        super(name, food, foodCounter, location, counter, health);
    }

    @Override
    public void makeSound() {
        System.out.println("TSOK-TSOK");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
        setFoodCounter(getFoodCounter() - 6);
        if (getFoodCounter() < 0) {
            System.out.println("Not enough food for that beast");
        } else System.out.println("Food left : " + getFoodCounter());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
