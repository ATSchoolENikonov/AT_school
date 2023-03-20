

public class Task_1 {
    void unique(String[] str) {
        int x = 0;
        while (x < str.length) {
            for (int i = x + 1; i < str.length; i++) {
                if (str[x].equals(str[i])) {
                    str[i] = str[i].replace(str[i], "");
                }
            }
            if (str[x].equals("")) {
                System.out.print(str[x]);
            } else {
                System.out.print(str[x] + " ");
            }
            x++;
        }
    }

    public static void main(String[] args) {
        Task_1 task = new Task_1();
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
        task.unique(args);
    }
}
