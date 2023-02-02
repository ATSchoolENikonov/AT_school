public class Task_1 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        Integer b = Integer.valueOf(args[1]);
        Integer c = Integer.valueOf(args[2]);
        if (a > b && a > c) {
            System.out.println(a);
        } else if (b > a && b > c) {
            System.out.println(b);
        } else if (c > a && c > b) {
            System.out.println(c);
        } else {
            System.out.println("Какие-либо из чисел равны");
        }
    }
}
