public class Task_3 {

    public void snakePrint(int n, int col) {
        int x = 0;
        int k = 2;
        while (x < n) {
            for (int i = 0; i < col; i++) {
                if (x == n) {
                    break;
                }
                x++;
                System.out.print(x + " ");
            }
            System.out.println();
            for (int i = 0, l = k * col; i < col; i++) {
                if (x == n) {
                    break;
                }
                x++;
                System.out.print(l + " ");
                l--;
            }
            System.out.println();
            k = k + 2;
        }
    }


    public static void main(String[] args) {
        Integer n = Integer.valueOf(args[0]);
        Integer col = Integer.valueOf(args[1]);
        if (n < 1 || col < 0) {
            System.out.println("Ошибка");
            System.exit(33);
        }
        Task_3 task = new Task_3();
        task.snakePrint(n, col);
    }
}
