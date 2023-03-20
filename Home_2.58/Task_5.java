import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task_5 {
    Random rnd = new Random();

    void fillArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(19) - 9;
        }
    }
    void fillDoubleArray(int[][] arrSum) {
        for (int i = 0; i < arrSum.length; i++) {
            fillArray(arrSum[i] = new int[rnd.nextInt(5) + 1]);
        }
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = 0; j < arrSum[i].length; j++) {
                arrSum[i][j] = rnd.nextInt(19) - 9;
            }
        }
    }

    void printArray(int[][] arrSum) {
        System.out.println(Arrays.deepToString(arrSum));
    }

    void checkSum(int[][] arrSum) {
        int[] sum = new int[arrSum.length];
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = 0; j < arrSum[i].length; j++) {
                sum[i] += arrSum[i][j];
            }
        }
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = i + 1; j < arrSum.length; j++) {
                if (sum[i] < sum[j]) {
                    int tmp[] = arrSum[i];
                    arrSum[i] = arrSum[j];
                    arrSum[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.deepToString(arrSum));
    }


    public static void main(String[] args) {
        Random column = new Random();
        int[][] arr = new int[column.nextInt(3) + 2][];
        Task_5 task = new Task_5();
        task.fillDoubleArray(arr);
        task.printArray(arr);
        task.checkSum(arr);
    }
}
