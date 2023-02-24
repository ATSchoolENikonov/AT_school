public class Task_2 {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(args[0]);
        Integer n = Integer.valueOf(args[1]);
        int f = n * 60;
        int sum = 0;
        if (m > 0 && n >= 0) {
            for (int i = 1; i < m; i++) {
                f = f + 10;
                sum += f;
            }
            int result = (n*60 + sum) / 60;
            System.out.println("Бригада работала " + result + " часов " + (sum % 60) + " минут");
        } else {
            System.out.println("Ошибка");
        }
    }
}
