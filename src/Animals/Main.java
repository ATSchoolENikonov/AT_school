package Animals;

public class Main {
    public static void main(String[] args) {
        Vet vet = new Vet("Greg");
        Dog doggy = new Dog("Bobik", "meat", 22, "Dvor", HealthState.UNHEALTHY);
        vet.treatAnimal(doggy);
        System.out.println(doggy);
        doggy.makeSound();
        doggy.eat();
        doggy.sleep();

        Cat cationok = new Cat("Barsik", "Korm", 5, "Apartment", HealthState.UNHEALTHY);
        vet.treatAnimal(cationok);
        System.out.println(cationok);
        cationok.makeSound();
        cationok.eat();

        Horse horse = new Horse("Plotva", "Seno", 44, "Roof", HealthState.HEALTHY);
        vet.treatAnimal(horse);
        System.out.println(horse);
        horse.makeSound();
        horse.eat();

        System.out.println(Animal.getCounter());
    }
}
