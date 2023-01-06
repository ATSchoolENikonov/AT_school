package Animals;

public class Dog extends Animal {

    public Dog(String name, String food, int foodCounter, String location, int counter, HealthState health) {
        super(name, food, foodCounter, location, counter, health);
    }

    @Override
    public void makeSound() {
        System.out.println("Gaf-Gaf");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
        setFoodCounter(getFoodCounter() - 4);
        if (getFoodCounter() < 0) {
            System.out.println("Not enough food for that beast");
        } else System.out.println("Food left : " + getFoodCounter());
    }

    @Override
    public void sleep() {
        System.out.println(getName()+ " is sleeping");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
