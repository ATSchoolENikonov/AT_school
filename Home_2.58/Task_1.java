import java.util.Arrays;
import java.util.Random;

public class Task_1 {


    void fillArray(int[] a) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(20) - 9;
            System.out.print(a[i] + " ");
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[20];
        Task_1 task = new Task_1();
        task.fillArray(arr);
    }
}
