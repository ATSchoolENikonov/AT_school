import java.util.Random;

public class Task_4 {
    boolean isPrime(int x) {
        boolean check = true;
        if (x < 2) {
            check = false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    int nextInt(int n) {
        Random rnd = new Random();
        return rnd.nextInt(n);
    }

    public static void main(String[] args) {
        boolean check = false;
        int n = 31;
        int x;
        Task_4 task4 = new Task_4();
        while (!check) {
            x = task4.nextInt(n);
            check = task4.isPrime(x);
            System.out.println(x);
            System.out.println(check);
        }

    }
}
