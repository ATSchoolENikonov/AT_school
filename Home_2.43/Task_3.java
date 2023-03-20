public class Task_3 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        if (a > 30000 || a <= 0) {
            System.out.println("There is mistake");
            return;
        }
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
