package Task_134;

public class Animal {
    public static String planet = "Earth";

    public static void testStaticMethod() {
        System.out.println("This is static animal");
    }

    public static void setPlanet(String planet) {
        Animal.planet = planet;
    }

    public static String getPlanet() {
        return planet;
    }
}
