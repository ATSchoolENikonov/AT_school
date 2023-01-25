package Task_134;

import static Task_134.Animal.*;

public class Main {

    public static void main(String[] args) {
        Cat cat4Par1 = new Cat(3, "Blue", 22.1, "Green");
        Cat cat4Par2 = new Cat(3, "Blue", "Red", 22.1);
        Cat cat3Par = new Cat(3, "Blue", 12.2);
        Cat cat2Par = new Cat(14, "Haki");
        Cat cat1Par1 = new Cat(14);
        Cat cat1Par2 = new Cat(23.3);
        System.out.println(cat4Par1.toString4());
        System.out.println(cat4Par2.toString4());
        System.out.println(cat3Par.toString3());
        System.out.println(cat2Par.toString2());
        System.out.println(cat1Par1.toStringAge());
        System.out.println(cat1Par2.toStringWeight());

        //Task3
        Animal.testStaticMethod();
        testStaticMethod();
        Cat.testStaticMethod();
        //Task4
        System.out.println(planet);
        Animal.setPlanet("Moon");
        System.out.println(cat2Par.getPlanet());
    }
}
