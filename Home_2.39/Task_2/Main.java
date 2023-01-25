package Task_2;

public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        double x = 6.6;
        double y = 7.7;
        double z = 8.8;
        Summa summa = new Summa();
        System.out.println(summa.sum(a, b));
        System.out.println(summa.sum(a, b, a));
        System.out.println(summa.sum(a, b, x, y, z));
        System.out.println(summa.sum(a, x, y));
        System.out.println(summa.sum((Integer) a, (Integer) b));
    }
}
