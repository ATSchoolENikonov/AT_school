import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Task_3 {
    public static void main(String[] args) {
        print(9, 7);
    }

    static void print(int n, int col) {
        int i = 1; // что печатать
        int printed = 0; // сколько напечатали на данный момент
        int direction = 1;

        while (printed < n) {
            System.out.print(i + " ");
            printed++;
            if (printed % col == 0) {
                System.out.println();
                direction = direction * -1;
                printSpaces(i + col - n);
                i = Math.min(i + col, n);
            } else {
                i += direction;
            }
        }
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
}
