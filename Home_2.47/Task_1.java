public class Task_1 {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(args[0]);
        Integer n = Integer.valueOf(args[1]);
        for (int x = m; x <= (n - m); x++) {
            if (x % 3 == 0 && x % 5 != 0) {
                System.out.println("X= " + x);
            }
        }
    }
}
