import java.util.Random;

public class Task_4 {
    boolean isPrime(int x) {
        if (x < 2) {
           return  false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
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
