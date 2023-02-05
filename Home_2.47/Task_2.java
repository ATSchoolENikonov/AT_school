public class Task_2 {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(args[0]);
        Integer n = Integer.valueOf(args[1]);
        int x = 0;
        if (m > 0 && n >= 0) {
            for (int i = 1; i < m; i++) {
                x += 10;
                if (x >= 60) {
                    n = n + 1;
                    x = 0;
                }
            }
            System.out.println("Бригада работала " + n + " часов " + x + " минут");
        } else {
            System.out.println("Ошибка");
        }
    }
}
