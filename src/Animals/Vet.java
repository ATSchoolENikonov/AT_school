package Animals;

public class Vet {
    private String name;

    public Vet(String name) {
        this.name = name;
    }

    public void treatAnimal(Animal animal) {
        animal.health = HealthState.HEALTHY;
    }
}
