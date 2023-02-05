public class Task_5 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]) * 100;
        Double b = Double.valueOf(args[1]);
        Integer c = Integer.valueOf(args[2]) * 100;
        Double d = Double.valueOf(args[3]);
        /**
         * Условия задания.Использовал Math,чтобы избежать значение 6999999 и тп
         */
        if (a >= 0 && b >= 0 && c >= 0 && d >= 0) {
            if ((a + b) <= (c + d)) {
                int calculate = (int) ((c + d) - (a + b));
                int e = calculate / 100;
                int f = calculate % 100;
                System.out.println("Ваша сдача: " + e + " Руб. " + f + " Коп.");
            } else {
                System.out.println("Не хватает денег на покупку");
            }
        } else {
            System.out.println("Ошибка");
        }
    }
}
