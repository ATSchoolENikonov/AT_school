package Animals;

public abstract class Animal {
    private String name;
    private String food;// не понял, зачем это, если по заданию и не используется
    private int foodCounter;
    private String location;
    private static int counter;
    private HealthState health;

    public static void setCounter(int counter) {
        Animal.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public void setHealth(HealthState health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getFoodCounter() {
        return foodCounter;
    }

    public Animal(String name, String food, int foodCounter, String location, HealthState health) {
        this.name = name;
        this.food = food;
        this.foodCounter = foodCounter;
        this.location = location;
        this.health = health;
        setCounter(getCounter() + 1);
    }

    public void setFoodCounter(int foodCounter) {
        this.foodCounter = foodCounter;
    }

    public abstract void makeSound();

    public abstract void eat();

    public abstract void sleep();

    @Override
    public String toString() {
        return "Name : " + name + "\n"
                + "Country of behavior : " + location + "\n"
                + "Number of species : " + counter + "\n"
                + "Health statement : " + health;
    }
}
