public class Task_4 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        Integer b = Integer.valueOf(args[1]);
        Integer c = Integer.valueOf(args[2]);
        /**
         * Условия задания 4.В данной реализации вариант impossible действительно impossible to reach
         */
        if (c * c == (a * a + b * b)) {
            System.out.println("right");
        } else if (c * c < (a * a + b * b)) {
            System.out.println("acute");
        } else if (c * c > (a * a + b * b)) {
            System.out.println("obtuse");
        } else {
            System.out.println("impossible");
        }
    }
}
