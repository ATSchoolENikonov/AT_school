package Task_134;

public class Cat extends Animal {
    private int age;
    private String ColorEyes;
    private double weight;
    private String ColorFur;


    public Cat(int age, String colorEyes, double weight, String colorFur) {
        this.age = age;
        ColorEyes = colorEyes;
        this.weight = weight;
        ColorFur = colorFur;
    }

    public Cat(int age, String colorEyes, String colorFur, double weight) {//Есть возможность изменить порядок вводимых параметров и это будет считаться новым конструктором
        this.age = age;
        ColorEyes = colorEyes;
        this.weight = weight;
        ColorFur = colorFur;
    }

    public Cat(int age, String colorEyes, double weight) {
        this.age = age;
        ColorEyes = colorEyes;
        this.weight = weight;
    }

    public Cat(String colorEyes, double weight, int age) {
        this.age = age;
        ColorEyes = colorEyes;
        this.weight = weight;
    }

    public Cat(int age, String colorEyes) {
        this.age = age;
        ColorEyes = colorEyes;
    }

    public Cat(String colorEyes, int age) {
        this.age = age;
        ColorEyes = colorEyes;
    }

    public Cat(int age) {
        this.age = age;
    }

    public Cat(double weight) {
        this.weight = weight;
    }

    public String getStatic() {
        return planet;
    }

    public String toString4(Cat cat) {
        return "Cat:" +
                " age=" + age +
                ", ColorEyes='" + ColorEyes + '\'' +
                ", weight=" + weight +
                ", ColorFur='" + ColorFur + '\'';
    }

    public String toString3(Cat cat) {
        return "Cat{" +
                "age=" + age +
                ", ColorEyes='" + ColorEyes + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String toString2(Cat cat) {
        return "Cat{" +
                "age=" + age +
                ", ColorEyes='" + ColorEyes +
                '}';
    }

    public String toStringAge(Cat cat) {
        return "Cat{" +
                "age=" + age +
                '}';
    }

    public String toStringWeight(Cat cat) {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }
}
