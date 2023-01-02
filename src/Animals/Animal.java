package Animals;

public abstract class Animal {
    private String name;
    private String food;// не понял, зачем это, если по заданию и не используется

    private int foodCounter;
    private String location;
    private int counter;
    HealthState health;

    public String getName() {
        return name;
    }

    public int getFoodCounter() {
        return foodCounter;
    }

    public Animal(String name, String food, int foodCounter, String location, int counter, HealthState health) {
        this.name = name;
        this.food = food;
        this.foodCounter = foodCounter;
        this.location = location;
        this.counter = counter;
        this.health = health;
    }

    public void setFoodCounter(int foodCounter) {
        this.foodCounter = foodCounter;
    }

    public void makeSound() {
        System.out.println("Animal voice");
    }

    public void eat() {
        System.out.println("Animal is eating");
        foodCounter--;
        System.out.println(foodCounter);
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    @Override
    public String toString() {
        return "Name : " + name + "\n"
                + "Country of behavior : " + location + "\n"
                + "Number of species : " + counter + "\n"
                + "Health statement : " + health;
    }
}
