public class Task_5 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        Double b = Double.valueOf(args[1]);
        Integer c = Integer.valueOf(args[2]);
        Double d = Double.valueOf(args[3]);
        /**
         * Условия задания.Использовал Math,чтобы избежать значение 6999999 и тп
         */
        if (a >= 0 && b >= 0 && c >= 0 && d >= 0) {
            if ((a + b) < (c + d)) {
                double result = (c + d) - (a + b);
                System.out.println("U'r payback: " + Math.nextUp(result));
            }else{
                System.out.println("Not enough money to buy");
            }
        }else {
            System.out.println("There is mistake");
        }
    }
}
