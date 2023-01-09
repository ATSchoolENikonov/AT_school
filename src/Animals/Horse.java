package Animals;

public class Horse extends Animal {

    public Horse(String name, String food, int foodCounter, String location, HealthState health) {
        super(name, food, foodCounter, location, health);
        setCounter(getCounter() + 1);
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
        } else {
            System.out.println("Food left : " + getFoodCounter());
        }
    }

    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
