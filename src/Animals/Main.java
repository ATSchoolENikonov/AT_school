package Animals;

public class Main {
    public static void main(String[] args) {
        Vet vet = new Vet("Greg");
        Dog doggy = new Dog("Bobik", "Meat", 1, "Dvor", 110, HealthState.UNHEALTHY);
        vet.treatAnimal(doggy);
        System.out.println(doggy);
        doggy.makeSound();
        doggy.eat();
        doggy.sleep();

        Cat cationok = new Cat("Barsik", "Korm", 5, "Apartment", 40, HealthState.UNHEALTHY);
        vet.treatAnimal(cationok);
        System.out.println(cationok);
        cationok.makeSound();
        cationok.eat();

        Horse horse = new Horse("Plotva", "Seno", 44, "Roof", 1, HealthState.HEALTHY);
        vet.treatAnimal(horse);
        System.out.println(horse);
        horse.makeSound();
        horse.eat();
    }
}
