import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task_5 {
    /*
    Сначало использовал метод из предущего задания, но потом решил по другому попробовать, оставил два варианта
     */
    void fillArray(int[] a) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(20) - 9;
//            System.out.print(a[i] + " ");
        }
    }

    void checkSum(int[][] arrSum) {
        arrSum[0] = new int[3]; //fillArray(arrSum[0] = new int[3]);
        arrSum[1] = new int[5]; //fillArray(arrSum[1] = new int[5]);
        arrSum[2] = new int[4]; //fillArray(arrSum[2] = new int[4]);
        arrSum[3] = new int[2]; //fillArray(arrSum[3] = new int[2]);
        Random rnd = new Random();
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = 0; j < arrSum[i].length; j++) {
                arrSum[i][j] = rnd.nextInt(20) - 9;
            }
        }
        int[] sum = new int[arrSum.length];
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = 0; j < arrSum[i].length; j++) {
                sum[i] += arrSum[i][j];
            }
        }
        for (int i = 0; i < arrSum.length; i++) {
            for (int j = i+1; j < arrSum.length ; j++) {
                if(sum[i]<sum[j]){
                    int tmp[]=arrSum[i];
                    arrSum[i]=arrSum[j];
                    arrSum[j]=tmp;
                }
            }
        }
        System.out.println(Arrays.deepToString(arrSum));
        /*
        Далее просто подсчитывается сумма элементов для проверки порядка по каждой строке
         */
        Arrays.sort(sum);
        for (int i = 0; i < sum.length / 2; i++) {
            int tmp = sum[i];
            sum[i] = sum[sum.length - i - 1];
            sum[sum.length - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(sum));
        /*
        Далее хотел с компаратором сделать, но что-то не пошло
         */
//       Arrays.sort(arrSum, new Comparator<int[]>() {
//           @Override
//           public int compare(int[] o1, int[] o2) {
//               return Integer.compare(o1[0],o2[0]);
//           }
//       });
//        System.out.println(Arrays.deepToString(arrSum));
    }


    public static void main(String[] args) {
        int[][] arr = new int[4][];
        Task_5 task = new Task_5();
        task.checkSum(arr);
    }
}
